package de.mcreloaded.custom.items;

import org.bukkit.NamespacedKey;

import de.mcreloaded.core.MCReloaded;

public enum ItemModifiers {
    PIGLIN_PASSIVE("piglin_passive","§6Piglin §7become §6Passive§7.",true),
    THUNDER_SHOT("thundershot","§7You can shoot §6Thunderbolts§7.",false),
    MINI_EXCAVATOR("mini_excavator","§7You can mine §63x3§7 blocks at one time.",false),
    MEGA_EXCAVATOR("mega_excavator","§7You can mine §65x10§7 blocks at one time.",false);
	
	final NamespacedKey key;
	final Boolean isSetBonus;
	final String description;
	
	ItemModifiers(String key, String description, Boolean isSetBonus){
		this.key = new NamespacedKey(MCReloaded.getPlugin(), "M-"+key);
		this.isSetBonus = isSetBonus;
		this.description = description;
	}
	
	public NamespacedKey getKey() {
		return key;
	}
	
	public boolean isSetBonus() {
		return isSetBonus;
	}
	
	public String getDescription() {
		return description;
	}
}
