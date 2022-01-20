package de.mcreloaded.tools;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class InventoryLibary {

	public final static void addItemToInventory(Player player, ItemStack item) {
		if (item != null && player != null) {
			if (player.getInventory().addItem(item).size() > 0) {
				player.getWorld().dropItem(player.getEyeLocation(), item);
			}
		}
	}
}
