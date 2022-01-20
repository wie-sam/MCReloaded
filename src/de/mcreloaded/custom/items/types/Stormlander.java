package de.mcreloaded.custom.items.types;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import de.mcreloaded.core.Core;
import de.mcreloaded.custom.items.CustomItem;
import de.mcreloaded.custom.items.ItemType;

public class Stormlander extends CustomItem implements Listener{

	public Stormlander() {
		super(ItemType.STORMLANDER);
		
		Bukkit.getPluginManager().registerEvents(this, Core.getPlugin());
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onInteract(PlayerInteractEvent e) {
		ItemStack item = e.getItem();
		
		if(item.getItemMeta().getPersistentDataContainer().get(ItemType.STORMLANDER.getIdentifierKey(), PersistentDataType.BYTE) != null) {
		
		}
	}
}
