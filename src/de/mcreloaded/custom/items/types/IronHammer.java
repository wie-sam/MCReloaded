package de.mcreloaded.custom.items.types;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.mcreloaded.core.Core;
import de.mcreloaded.custom.items.CustomItem;
import de.mcreloaded.custom.items.ItemType;
import de.mcreloaded.custom.items.LoreBuilder;

public final class IronHammer extends CustomItem implements Listener{

	//Generating default IronHammer Item
	public IronHammer() {
		super(new ItemStack(Material.IRON_PICKAXE), ItemType.IRONHAMMER);
		updateLore(new LoreBuilder(this).addDescriptionLine("Test").addDescriptionLine("TEst1"));
		setCustomModelData(1);
		
		Bukkit.getPluginManager().registerEvents(this, Core.getPlugin());	
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Bukkit.broadcastMessage("Test");
	}
}
