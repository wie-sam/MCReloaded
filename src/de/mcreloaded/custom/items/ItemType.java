package de.mcreloaded.custom.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import de.mcreloaded.core.Core;

public enum ItemType {

	IRONHAMMER("ironhammer", "§fIron Hammer", Material.IRON_PICKAXE, 305001, List.of(ItemModifiers.MINI_EXCAVATOR)),
	STORMLANDER("stormlander", "§fStormlander", Material.IRON_PICKAXE, 305002, List.of(ItemModifiers.THUNDER_SHOT, ItemModifiers.MINI_EXCAVATOR));
	
	final NamespacedKey key;
	final String name;
	final Material material;
	final int custommodeldataid;
	final List<ItemModifiers> modifierlist;
	
	ItemType(String key, String name, Material material, int custommodeldataid, List<ItemModifiers> modifierlist){
		this.key = new NamespacedKey(Core.getPlugin(), key);
		this.name = name;
		this.material = material;
		this.custommodeldataid = custommodeldataid;
		this.modifierlist = modifierlist;
	}
	
	public NamespacedKey getIdentifierKey() {
		return this.key;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCustomModelDataID() {
		return this.custommodeldataid;
	}
	
	public List<ItemModifiers> getModifiers(){
		return this.modifierlist;
	}
	
	public Material getMaterial() {
		return this.material;
	}
}
