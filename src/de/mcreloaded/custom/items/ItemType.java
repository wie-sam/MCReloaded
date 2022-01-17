package de.mcreloaded.custom.items;

import org.bukkit.NamespacedKey;

import de.mcreloaded.core.Core;

public enum ItemType {

	IRONHAMMER(new NamespacedKey(Core.getPlugin(), "ironhammer"));
	
	final NamespacedKey key;

	ItemType(NamespacedKey key){
		this.key = key;
	}
	
	public NamespacedKey getIdentifierKey() {
		return this.key;
	}
	
}
