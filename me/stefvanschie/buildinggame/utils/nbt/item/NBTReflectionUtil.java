/* --------------------------------------------------------------------------------------------------------------------
 * | Credits to tr7zw                                                                                                 |
 * | SpigotMC's plugin page: https://www.spigotmc.org/resources/item-nbt-api.7939/                                    |
 * | SpigotMC's user page: https://www.spigotmc.org/resources/authors/tr7zw.27296/                                    |
 * | Github project: https://github.com/tr7zw/Item-NBT-API/blob/master/src/de/tr7zw/itemnbtapi/NBTReflectionutil.java |
 * --------------------------------------------------------------------------------------------------------------------
 */

package me.stefvanschie.buildinggame.utils.nbt.item;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class NBTReflectionUtil {

	private static Class<?> getCraftItemstack(){
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
		try {
			Class<?> c = Class.forName("org.bukkit.craftbukkit." + version +".inventory.CraftItemStack");
			return c;
		} catch(Exception ex) {
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			ex.printStackTrace();
			return null;
		}
	}

	private static Object getnewNBTTag(){
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
		try {
			Class<?> c = Class.forName("net.minecraft.server." + version +".NBTTagCompound");
			return c.newInstance();
		} catch(Exception ex) {
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			ex.printStackTrace();
			return null;
		}
	}
	
	private static Object setNBTTag(Object NBTTag, Object NMSItem){
		try {
			java.lang.reflect.Method method;
			method = NMSItem.getClass().getMethod("setTag", NBTTag.getClass());
			method.invoke(NMSItem, NBTTag);
			return NMSItem;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static Object getNMSItemStack(ItemStack item){
		Class<?> cis = getCraftItemstack();
		java.lang.reflect.Method method;
		try {
			method = cis.getMethod("asNMSCopy", ItemStack.class);
			Object answer = method.invoke(cis, item);
			return answer;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	private static ItemStack getBukkitItemStack(Object item){
		Class<?> cis = getCraftItemstack();
		java.lang.reflect.Method method;
		try {
			method = cis.getMethod("asBukkitCopy", item.getClass());
			Object answer = method.invoke(cis, item);
			return (ItemStack) answer;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	private static Object getNBTTagCompound(Object nmsitem){
		Class<?> c = nmsitem.getClass();
		java.lang.reflect.Method method;
		try {
			method = c.getMethod("getTag");
			Object answer = method.invoke(nmsitem);
			return answer;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

	public static ItemStack setString(ItemStack item, String key, String Text){
		Object nmsitem = getNMSItemStack(item);
		
		if(nmsitem == null){
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try{
			method = nbttag.getClass().getMethod("setString", String.class, String.class);
			method.invoke(nbttag, key, Text);
			nmsitem = setNBTTag(nbttag, nmsitem);
			return getBukkitItemStack(nmsitem);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return item;
	}
	
	public static String getString(ItemStack item, String key){
		Object nmsitem = getNMSItemStack(item);
		
		if (nmsitem == null) {
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("getString", String.class);
			return (String) method.invoke(nbttag, key);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static ItemStack setInt(ItemStack item, String key, Integer i){
		Object nmsitem = getNMSItemStack(item);
		
		if (nmsitem == null) {
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("setInt", String.class, int.class);
			method.invoke(nbttag, key, i);
			nmsitem = setNBTTag(nbttag, nmsitem);
			return getBukkitItemStack(nmsitem);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return item;
	}

	public static Integer getInt(ItemStack item, String key){
		Object nmsitem = getNMSItemStack(item);
		
		if (nmsitem == null) {
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("getInt", String.class);
			return (Integer) method.invoke(nbttag, key);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static ItemStack setDouble(ItemStack item, String key, Double d){
		Object nmsitem = getNMSItemStack(item);
		
		if(nmsitem == null){
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("setDouble", String.class, double.class);
			method.invoke(nbttag, key, d);
			nmsitem = setNBTTag(nbttag, nmsitem);
			return getBukkitItemStack(nmsitem);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return item;
	}
	
	public static Double getDouble(ItemStack item, String key){
		Object nmsitem = getNMSItemStack(item);
		
		if(nmsitem == null){
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("getDouble", String.class);
			return (Double) method.invoke(nbttag, key);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static ItemStack setBoolean(ItemStack item, String key, Boolean d){
		Object nmsitem = getNMSItemStack(item);
		
		if(nmsitem == null){
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("setBoolean", String.class, boolean.class);
			method.invoke(nbttag, key, d);
			nmsitem = setNBTTag(nbttag, nmsitem);
			return getBukkitItemStack(nmsitem);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return item;
	}

	public static Boolean getBoolean(ItemStack item, String key){
		Object nmsitem = getNMSItemStack(item);
		
		if(nmsitem == null){
			System.out.println("Error in item loading. Make sure you're using the latest version.");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if(nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("getBoolean", String.class);
			return (Boolean) method.invoke(nbttag, key);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static Boolean hasKey(ItemStack item, String key){
		Object nmsitem = getNMSItemStack(item);
		
		if(nmsitem == null){
			System.out.println("Error in item loading. Make sure you're using the latest version.)");
			return null;
		}
		
		Object nbttag = getNBTTagCompound(nmsitem);
		
		if (nbttag == null) {
			nbttag = getnewNBTTag();
		}
		
		java.lang.reflect.Method method;
		
		try {
			method = nbttag.getClass().getMethod("hasKey", String.class);
			return (Boolean) method.invoke(nbttag, key);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}