/* ----------------------------------------------------------------------------------------------------------
 * | Credits to tr7zw                                                                                       |
 * | SpigotMC's plugin page: https://www.spigotmc.org/resources/item-nbt-api.7939/                          |
 * | SpigotMC's user page: https://www.spigotmc.org/resources/authors/tr7zw.27296/                          |
 * | Github project: https://github.com/tr7zw/Item-NBT-API/blob/master/src/de/tr7zw/itemnbtapi/NBTItem.java |
 * ----------------------------------------------------------------------------------------------------------
 */

package me.stefvanschie.buildinggame.utils.nbt.item;

import org.bukkit.inventory.ItemStack;

public class NBTItem {
	
	private ItemStack bukkititem;
	
	public NBTItem(ItemStack Item){
		bukkititem = Item.clone();
	}
	
	public ItemStack getItem(){
		return bukkititem;
	}
	
	public void setString(String Key, String Text){
		bukkititem = NBTReflectionUtil.setString(bukkititem, Key, Text);
	}
	
	public String getString(String Key){
		return NBTReflectionUtil.getString(bukkititem, Key);
	}
	
	public void setInteger(String key, Integer Int){
		bukkititem = NBTReflectionUtil.setInt(bukkititem, key, Int);
	}
	
	public Integer getInteger(String key){
		return NBTReflectionUtil.getInt(bukkititem, key);
	}
	
	public void setDouble(String key, Double d){
		bukkititem = NBTReflectionUtil.setDouble(bukkititem, key, d);
	}
	
	public Double getDouble(String key){
		return NBTReflectionUtil.getDouble(bukkititem, key);
	}
	
	public void setBoolean(String key, Boolean b){
		bukkititem = NBTReflectionUtil.setBoolean(bukkititem, key, b);
	}
	
	public Boolean getBoolean(String key){
		return NBTReflectionUtil.getBoolean(bukkititem, key);
	}
	
	public Boolean hasKey(String key){
		return NBTReflectionUtil.hasKey(bukkititem, key);
	}
}