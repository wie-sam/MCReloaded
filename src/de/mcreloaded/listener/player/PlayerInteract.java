package de.mcreloaded.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.mcreloaded.core.MCReloaded;
import de.mcreloaded.tools.usermanager.UserProfile;

public class PlayerInteract implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		UserProfile up = MCReloaded.getPlugin().USERMANAGER.getProfile(player.getUniqueId());
		up.setLastBlockFace(e.getBlockFace());
	}
	
	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent e) {
		
	}
}
