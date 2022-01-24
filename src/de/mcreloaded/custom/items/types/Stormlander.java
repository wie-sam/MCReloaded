package de.mcreloaded.custom.items.types;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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
		
		if(isCorrectItem(item)) {
			
				final Location playerLoc = e.getPlayer().getLocation();
				ArmorStand bolt = (ArmorStand) playerLoc.getWorld().spawnEntity(playerLoc, EntityType.ARMOR_STAND);
				final Vector velocity = e.getPlayer().getLocation().getDirection().add(new Vector(0, 0.025, 0)).multiply(3);	
				bolt.setVelocity(velocity);
				bolt.setInvisible(true);
				bolt.setArms(false);
				bolt.setCustomName("Bolt");
				new BukkitRunnable() {	
					@Override
					public void run() {
						if(bolt.isOnGround()) {
							final Location spawnloc = bolt.getLocation();
							bolt.remove();
							spawnloc.getWorld().strikeLightning(spawnloc);
							spawnloc.getWorld().strikeLightning(spawnloc.add(1,0,0));
							spawnloc.getWorld().strikeLightning(spawnloc.add(-1,0,0));
							spawnloc.getWorld().strikeLightning(spawnloc.add(0,0,1));
							spawnloc.getWorld().strikeLightning(spawnloc.add(0,0,-1));
							cancel();
						}
					}
				}.runTaskTimer(Core.getPlugin(), 0, 10l);
			
		}
	}
}
