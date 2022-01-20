package de.mcreloaded.custom.items;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import de.mcreloaded.custom.exceptions.CustomItemNotFoundExeption;

public class CustomItem {
	
	private final ItemStack itemstack;
	private final ItemType itemtype;
	
	public CustomItem(ItemType itemtype) {
		this.itemtype = itemtype;
		ItemStack is = new ItemStack(itemtype.getMaterial());
		final ItemMeta itemmeta = is.getItemMeta();
		final PersistentDataContainer pdc = itemmeta.getPersistentDataContainer();
		pdc.set(itemtype.getIdentifierKey(), PersistentDataType.BYTE, (byte) 1);
		itemmeta.setDisplayName(itemtype.getName());
		itemmeta.setCustomModelData(itemtype.getCustomModelDataID());
		is.setItemMeta(itemmeta);
		this.itemstack = is;
		
		updateLore(new LoreBuilder(this));
	}
	
	//Vererbt eine alte CustomItem Instance und generiert einen neuen HashCode
	public CustomItem(CustomItem customitem) {
		this.itemtype = customitem.getItemType();
		this.itemstack = customitem.getItemStack();
	}
	
	
	public CustomItem(ItemStack itemstack) throws CustomItemNotFoundExeption{
		if(itemstack.hasItemMeta()) {
			final ItemMeta itemmeta = itemstack.getItemMeta();
			final PersistentDataContainer pdc = itemmeta.getPersistentDataContainer();
			ItemType ikey = null;
			for(NamespacedKey keys : pdc.getKeys()) {
				for(ItemType itemtypes : ItemType.values()) {
					if(itemtypes.getIdentifierKey().equals(keys)) {
						ikey = itemtypes;
						break;
					}
				}
			}
			
			if(!ikey.equals(null)) {
				this.itemtype = ikey;
				this.itemstack = itemstack;
				return;
			}
		}
		throw new CustomItemNotFoundExeption("Could not find an CustomItem on this Item");
	}
	
	public final void setCustomModelData(int custommodeldata) {
		final ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setCustomModelData(custommodeldata);
		itemstack.setItemMeta(itemmeta);
	}
	
	public final void updateLore(LoreBuilder lorebuilder) {
		final ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.setLore(lorebuilder.build());
		itemstack.setItemMeta(itemmeta);
	}
	
	public final ItemStack getItemStack() {
		return itemstack;
	}
	
	public final void addItemFlags(ItemFlag... itemflag) {
		final ItemMeta itemmeta = itemstack.getItemMeta();
		itemmeta.addItemFlags(itemflag);
		itemstack.setItemMeta(itemmeta);
	}
	
	public final ItemType getItemType() {
		return itemtype;
	}
	
}
