package me.stefvanschie.buildinggame.utils.nbt.entity;

import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

public class NmsClasses {

	private NmsClasses() {}
	
	public static void setTag(Entity entity, Object tag) {
		Object nms = null;
		try {
			nms = entity.getClass().getMethod("getHandle").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    Class<?> entityClass = nms.getClass();
	    Method[] methods = entityClass.getMethods();
	    for (Method method : methods) {
	        if ((method.getName() == "a")
			        && (method.getParameterTypes().length == 1)
			        && (method.getParameterTypes()[0] == getClass("NBTTagCompound"))) {
			    try {
			        method.setAccessible(true);
			        method.invoke(nms, (getClass("NBTTagCompound")).cast(tag));
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}
	    }
	}
	
	private static String getVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}
	
	private static Class<?> getClass(String name) {
		try {
			return Class.forName("net.minecraft.server." + getVersion() + "." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}