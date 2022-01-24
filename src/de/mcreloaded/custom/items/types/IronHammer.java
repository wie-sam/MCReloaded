package de.mcreloaded.custom.items.types;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.mcreloaded.core.Core;
import de.mcreloaded.custom.items.CustomItem;
import de.mcreloaded.custom.items.ItemType;
import de.mcreloaded.tools.ChunkLibary;

public final class IronHammer extends CustomItem implements Listener {

	// Generating default IronHammer Item
	public IronHammer() {
		super(ItemType.IRONHAMMER);       
		
		Bukkit.getPluginManager().registerEvents(this, Core.getPlugin());
	}

	@SuppressWarnings({ "deprecation", "incomplete-switch" })
	@EventHandler(priority = EventPriority.LOW)
	public void onBreak(BlockBreakEvent e) {
		if(e.isCancelled()) 
			return;
		
		Player player = e.getPlayer();
		ItemStack item = new ItemStack(player.getItemInHand());
		
		if(isCorrectItem(item)){
			BlockFace face = Core.getPlugin().USERMANAGER.getProfile(player.getUniqueId()).getLastBlockFace();
			Block block = e.getBlock();
			boolean isGamemode = !player.getGameMode().equals(GameMode.CREATIVE);
			
			switch (face) {
				case NORTH:
				case SOUTH:
					if (block.getLocation().add(-1, -1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(-1, -1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(0, -1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, -1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(1, -1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(1, -1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(-1, 0, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(-1, 0, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(1, 0, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(1, 0, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(-1, 1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(-1, 1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(1, 1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(1, 1, 0), isGamemode, player, item);
					}
					break;
				case DOWN:
				case UP:
					if (block.getLocation().add(-1, 0, 1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(-1, 0, 1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 0, 1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 0, 1), isGamemode, player, item);
					}
					if (block.getLocation().add(1, 0, 1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(1, 0, 1), isGamemode, player, item);
					}
					if (block.getLocation().add(-1, 0, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(-1, 0, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(1, 0, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(1, 0, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(-1, 0, -1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(-1, 0, -1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 0, -1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 0, -1), isGamemode, player, item);
					}
					if (block.getLocation().add(1, 0, -1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(1, 0, -1), isGamemode, player, item);
					}
					break;
				case WEST:
				case EAST:
					if (block.getLocation().add(0, -1, -1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, -1, -1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, -1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, -1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(0, -1, 1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, -1, 1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 0, -1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 0, -1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 0, 1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 0, 1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 1, -1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 1, -1), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 1, 0).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 1, 0), isGamemode, player, item);
					}
					if (block.getLocation().add(0, 1, 1).getBlock().getType().equals(block.getType())) {
						ChunkLibary.breakblock(block.getLocation().add(0, 1, 1), isGamemode, player, item);
					}
					break;
			}
		}
	}
}
