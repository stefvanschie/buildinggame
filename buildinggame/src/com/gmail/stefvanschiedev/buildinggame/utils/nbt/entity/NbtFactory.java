/*
 * Credits to Comphenix
 */

package com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.MapMaker;
import com.google.common.primitives.Primitives;

@SuppressWarnings("deprecation")
public class NbtFactory {   
    // Convert between NBT id and the equivalent class in java
    private static final BiMap<Integer, Class<?>> NBT_CLASS = HashBiMap.create();
    private static final BiMap<Integer, NbtType> NBT_ENUM = HashBiMap.create();
    
    @SuppressWarnings("unused")
    private enum NbtType {
        TAG_END(0, Void.class),
        TAG_BYTE(1, byte.class),
        TAG_SHORT(2, short.class),
        TAG_INT(3, int.class),
        TAG_LONG(4, long.class),
        TAG_FLOAT(5, float.class),
        TAG_DOUBLE(6, double.class),
        TAG_BYTE_ARRAY(7, byte[].class),
        TAG_INT_ARRAY(11, int[].class),
        TAG_STRING(8, String.class),
        TAG_LIST(9, List.class),
        TAG_COMPOUND(10, Map.class);

        // Unique NBT id
        public final int id;
        
        NbtType(int id, Class<?> type) {
            this.id = id;
            NBT_CLASS.put(id, type);
            NBT_ENUM.put(id, this);
        }
        
        private String getFieldName() {
            if (this == TAG_COMPOUND) 
                return "map";
            else if (this == TAG_LIST)
                return "list";
            else
                return "data";
        }
    }
    
    // The NBT base class
    private Class<?> BASE_CLASS;
    private Method NBT_CREATE_TAG;
    private Method NBT_GET_TYPE;
    private Field NBT_LIST_TYPE;
    private final Field[] DATA_FIELD = new Field[12];

    // Shared instance
    private static NbtFactory INSTANCE;
    
    public final class NbtCompound extends ConvertedMap {
        private NbtCompound(Object handle) {
            super(handle, getDataMap(handle));
        }
    }
    
    /**
     * Represents a root NBT list.
     * @author Kristian
     */
    public final class NbtList extends ConvertedList {
        private NbtList(Object handle) {
            super(handle, getDataList(handle));
        }
    }
    
    /**
     * Represents an object that provides a view of a native NMS class.
     * @author Kristian
     */
    public interface Wrapper {
        /**
         * Retrieve the underlying native NBT tag.
         * @return The underlying NBT.
         */
        Object getHandle();
    }
    
    /**
     * Retrieve or construct a shared NBT factory.
     * @return The factory.
     */
    private static NbtFactory get() {
        if (INSTANCE == null)
            INSTANCE = new NbtFactory();
        return INSTANCE;
    }
    
    /**
     * Construct an instance of the NBT factory by deducing the class of NBTBase.
     */
    private NbtFactory() {
        if (BASE_CLASS == null) {
            try {
                // Keep in mind that I do use hard-coded field names - but it's okay as long as we're dealing 
                // with CraftBukkit or its derivatives. This does not work in MCPC+ however.
                ClassLoader loader = NbtFactory.class.getClassLoader();
                
                String packageName = getPackageName();
                Class<?> offlinePlayer = loader.loadClass(packageName + ".CraftOfflinePlayer");
                
                // Prepare NBT
                Class<?> COMPOUND_CLASS = getMethod(0, Modifier.STATIC, offlinePlayer, "getData").getReturnType();
                BASE_CLASS = COMPOUND_CLASS.getSuperclass();
                NBT_GET_TYPE = getMethod(0, Modifier.STATIC, BASE_CLASS, "getTypeId");
                NBT_CREATE_TAG = getMethod(Modifier.STATIC, 0, BASE_CLASS, "createTag", byte.class);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Unable to find offline player.", e);
            }
        }
    }
     
    private String getPackageName() {
    	Server server = Bukkit.getServer();
		String name = server != null ? server.getClass().getPackage().getName() : null;
    	
    	if (name != null && name.contains("craftbukkit")) {
    		return name;
    	} else {
    		// Fallback
    		return "org.bukkit.craftbukkit.v1_7_R3"; 
    	}
    } 
    
    @SuppressWarnings("unchecked")
    private Map<String, Object> getDataMap(Object handle) {
        return (Map<String, Object>) getFieldValue(
            getDataField(NbtType.TAG_COMPOUND, handle), handle);
    }
    
    @SuppressWarnings("unchecked")
    private List<Object> getDataList(Object handle) {
        return (List<Object>) getFieldValue(
            getDataField(NbtType.TAG_LIST, handle), handle);
    }
    
    /**
     * Construct a new NBT compound.
     * @return The NBT compound.
     */
    public static NbtCompound createCompound() {
        return get().new NbtCompound(
            INSTANCE.createNbtTag(NbtType.TAG_COMPOUND, null)
        );
    }
    
    /**
     * Convert wrapped List and Map objects into their respective NBT counterparts.
     * @param value - the value of the element to create. Can be a List or a Map.
     * @return The NBT element.
     */
    private Object unwrapValue(Object value) {
        if (value == null)
            return null;
        
        if (value instanceof Wrapper) {
            return ((Wrapper) value).getHandle();
            
        } else if (value instanceof List) {
            throw new IllegalArgumentException("Can only insert a WrappedList.");
        } else if (value instanceof Map) {
            throw new IllegalArgumentException("Can only insert a WrappedCompound.");
            
        } else {
            return createNbtTag(getPrimitiveType(value), value);
        }
    }
    
    /**
     * Convert a given NBT element to a primitive wrapper or List/Map equivalent.
     * <p>
     * All changes to any mutable objects will be reflected in the underlying NBT element(s).
     * @param nms - the NBT element.
     * @return The wrapper equivalent.
     */
    private Object wrapNative(Object nms) {
        if (nms == null)
            return null;

        if (BASE_CLASS.isAssignableFrom(nms.getClass())) {
            final NbtType type = getNbtType(nms);
            
            // Handle the different types
            switch (type) {
                case TAG_COMPOUND:
                    return new NbtCompound(nms);
                case TAG_LIST:
                    return new NbtList(nms);
                default:
                    return getFieldValue(getDataField(type, nms), nms);
            }
        }
        throw new IllegalArgumentException("Unexpected type: " + nms);
    }
    
    /**
     * Construct a new NMS NBT tag initialized with the given value.
     * @param type - the NBT type.
     * @param value - the value, or NULL to keep the original value.
     * @return The created tag.
     */
    private Object createNbtTag(NbtType type, Object value) {
        Object tag = invokeMethod(NBT_CREATE_TAG, null, (byte)type.id);

        if (value != null) {
            setFieldValue(getDataField(type, tag), tag, value);
        }
        return tag;
    }
    
    /**
     * Retrieve the field where the NBT class stores its value.
     * @param type - the NBT type.
     * @param nms - the NBT class instance.
     * @return The corresponding field.
     */
    private Field getDataField(NbtType type, Object nms) {
        if (DATA_FIELD[type.id] == null) 
            DATA_FIELD[type.id] = getField(nms, null, type.getFieldName());
        return DATA_FIELD[type.id];
    }
    
    /**
     * Retrieve the NBT type from a given NMS NBT tag.
     * @param nms - the native NBT tag.
     * @return The corresponding type.
     */
    private NbtType getNbtType(Object nms) {
        int type = (Byte) invokeMethod(NBT_GET_TYPE, nms);
        return NBT_ENUM.get(type);
    }
    
    /**
     * Retrieve the nearest NBT type for a given primitive type.
     * @param primitive - the primitive type.
     * @return The corresponding type.
     */
    private NbtType getPrimitiveType(Object primitive) {
        NbtType type = NBT_ENUM.get(NBT_CLASS.inverse().get(
            Primitives.unwrap(primitive.getClass())
        ));
        
        // Display the illegal value at least
        if (type == null)
            throw new IllegalArgumentException(String.format(
                "Illegal type: %s (%s)", primitive.getClass(), primitive));
        return type;
    }

    /**
     * Invoke a method on the given target instance using the provided parameters.
     * @param method - the method to invoke.
     * @param target - the target.
     * @param params - the parameters to supply.
     * @return The result of the method.
     */
    private static Object invokeMethod(Method method, Object target, Object... params) {
        try {
            return method.invoke(target, params);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke method " + method + " for " + target, e);
        }
    }
    
    private static void setFieldValue(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException("Unable to set " + field + " for " + target, e);
        }
    }
    
    private static Object getFieldValue(Field field, Object target) {
        try {
            return field.get(target);
        } catch (Exception e) {
            throw new RuntimeException("Unable to retrieve " + field + " for " + target, e);
        }
    }
    
    /**
     * Search for the first publically and privately defined method of the given name and parameter count.
     * @param requireMod - modifiers that are required.
     * @param bannedMod - modifiers that are banned.
     * @param clazz - a class to start with.
     * @param methodName - the method name, or NULL to skip.
     * @param params - the expected parameters.
     * @return The first method by this name.
     * @throws IllegalStateException If we cannot find this method.
     */
    private static Method getMethod(int requireMod, int bannedMod, Class<?> clazz, String methodName, Class<?>... params) {
        for (Method method : clazz.getDeclaredMethods()) {
            // Limitation: Doesn't handle overloads
            if ((method.getModifiers() & requireMod) == requireMod &&
                (method.getModifiers() & bannedMod) == 0 &&
                (methodName == null || method.getName().equals(methodName)) && 
                 Arrays.equals(method.getParameterTypes(), params)) {
                
                method.setAccessible(true);
                return method;
            }
        }
        // Search in every superclass
        if (clazz.getSuperclass() != null)
            return getMethod(requireMod, bannedMod, clazz.getSuperclass(), methodName, params);
        throw new IllegalStateException(String.format(
            "Unable to find method %s (%s).", methodName, Arrays.asList(params)));
    }
    
    /**
     * Search for the first publically and privately defined field of the given name. 
     * @param instance - an instance of the class with the field.
     * @param clazz - an optional class to start with, or NULL to deduce it from instance.
     * @param fieldName - the field name.
     * @return The first field by this name.
     * @throws IllegalStateException If we cannot find this field.
     */
    private static Field getField(Object instance, Class<?> clazz, String fieldName) {
        if (clazz == null) 
            clazz = instance.getClass();
        // Ignore access rules
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                return field;
            }
        }
        // Recursively fild the correct field
        if (clazz.getSuperclass() != null)
            return getField(instance, clazz.getSuperclass(), fieldName);
        throw new IllegalStateException("Unable to find field " + fieldName + " in " + instance);
    }
    
    /**
     * Represents a class for caching wrappers.
     * @author Kristian
     */
    private final class CachedNativeWrapper {
        // Don't recreate wrapper objects
        private final ConcurrentMap<Object, Object> cache = new MapMaker().weakKeys().makeMap();
        
        public Object wrap(Object value) {
            Object current = cache.get(value);
            
            if (current == null) {
                current = wrapNative(value);
                
                // Only cache composite objects
                if (current instanceof ConvertedMap || 
                    current instanceof ConvertedList) {
                    cache.put(value, current);
                }
            }
            return current;
        }
    }
    
    /**
     * Represents a map that wraps another map and automatically 
     * converts entries of its type and another exposed type.
     * @author Kristian
     */
    private class ConvertedMap extends AbstractMap<String, Object> implements Wrapper {
        private final Object handle;
        private final Map<String, Object> original;
        
        private final CachedNativeWrapper cache = new CachedNativeWrapper();

        public ConvertedMap(Object handle, Map<String, Object> original) {
            this.handle = handle;
            this.original = original;
        }
        
        // For converting back and forth
        Object wrapOutgoing(Object value) {
            return cache.wrap(value);
        }
        Object unwrapIncoming(Object wrapped) {
            return unwrapValue(wrapped);
        }
        
        // Modification
        @Override
        public Object put(String key, Object value) {
            return wrapOutgoing(original.put(
                key,
                unwrapIncoming(value)
            ));
        }
        
        // Performance
        @Override
        public Object get(Object key) {
            return wrapOutgoing(original.get(key));
        }
        @Override
        public Object remove(Object key) {
            return wrapOutgoing(original.remove(key));
        }
        @Override
        public boolean containsKey(Object key) {
            return original.containsKey(key);
        }

        @SuppressWarnings("NullableProblems")
        @Override
        public Set<Entry<String, Object>> entrySet() {
            return new AbstractSet<Entry<String,Object>>() {
                @Override
                public boolean add(Entry<String, Object> e) {
                    String key = e.getKey();
                    Object value = e.getValue();
                    
                    original.put(key, unwrapIncoming(value));
                    return true;
                }
                
                @Override
                public int size() {
                    return original.size();
                }
                
                @SuppressWarnings("NullableProblems")
                @Override
                public Iterator<Entry<String, Object>> iterator() {
                    return ConvertedMap.this.iterator();
                }
            };
        }
        
        private Iterator<Entry<String, Object>> iterator() {
            final Iterator<Entry<String, Object>> proxy = original.entrySet().iterator();
            
            return new Iterator<Entry<String, Object>>() {
                @Override
                public boolean hasNext() {
                    return proxy.hasNext();
                }
                
                @Override
                public Entry<String, Object> next() {
                    Entry<String, Object> entry = proxy.next();
                    
                    return new SimpleEntry<>(
                        entry.getKey(), wrapOutgoing(entry.getValue())
                    );
                }
                
                @Override
                public void remove() {
                    proxy.remove();
                }
            };
        }
        
        @Override
        public Object getHandle() {
            return handle;
        }
    }
    
    /**
     * Represents a list that wraps another list and converts elements 
     * of its type and another exposed type.
     * @author Kristian
     */
    private class ConvertedList extends AbstractList<Object> implements Wrapper {
        private final Object handle;
        
        private final List<Object> original;
        private final CachedNativeWrapper cache = new CachedNativeWrapper();
        
        public ConvertedList(Object handle, List<Object> original) {
            if (NBT_LIST_TYPE == null)
                NBT_LIST_TYPE = getField(handle, null, "type");
            this.handle = handle;
            this.original = original;
        }

        Object wrapOutgoing(Object value) {
            return cache.wrap(value);
        }
        Object unwrapIncoming(Object wrapped) {
            return unwrapValue(wrapped);
        }
        
        @Override
        public Object get(int index) {
            return wrapOutgoing(original.get(index));
        }
        @Override
        public int size() {
            return original.size();
        }
        @Override
        public Object set(int index, Object element) {
            return wrapOutgoing(
                original.set(index, unwrapIncoming(element))
            );
        }
        @Override
        public void add(int index, Object element) {
            Object nbt = unwrapIncoming(element);
            
            // Set the list type if its the first element
            if (size() == 0) 
                setFieldValue(NBT_LIST_TYPE, handle, (byte)getNbtType(nbt).id);
            original.add(index, nbt);
        }
        @Override
        public Object remove(int index) {
            return wrapOutgoing(original.remove(index));
        }
        @Override
        public boolean remove(Object o) {
            return original.remove(unwrapIncoming(o));
        }
        
        @Override
        public Object getHandle() {
            return handle;
        }
    }
}