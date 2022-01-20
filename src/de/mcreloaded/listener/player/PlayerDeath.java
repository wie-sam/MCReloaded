package de.mcreloaded.listener.player;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.mcreloaded.core.Core;
import de.mcreloaded.tools.MathLibary;
import de.mcreloaded.tools.NPCLibary;

public class PlayerDeath implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {  
    	Player p = e.getEntity();
    	Entity k = p.getKiller();
    	spawnNPC(p);
	    if(k != null) { 	
	        for(Player player : Bukkit.getOnlinePlayers()) {
	        	if(p == player) {
	        		player.sendMessage(" §c☠ §7You were killed by " + k.getName());	
	            }else {
	            	player.sendMessage(" §c☠ §7" + p.getName() +" was killed by " + k.getName());
	            }
	      	}
	    	ItemStack skullinfo = new ItemStack(Material.PLAYER_HEAD);
	    	SkullMeta skullinfo1 = (SkullMeta) skullinfo.getItemMeta();
	    	skullinfo1.setOwner(p.getName());
	    	skullinfo.setItemMeta(skullinfo1);
	      	p.getWorld().dropItemNaturally(p.getEyeLocation(), skullinfo);     	
		}else {
			String deathmessage = e.getDeathMessage();
			if(deathmessage == null){
				deathmessage = p.getName()+" died";
			}
			for(Player player : Bukkit.getOnlinePlayers()) {	 
		    	if(p == player) {
		        	player.sendMessage(" §c☠ §7"+deathmessage.replace(p.getName(), "You"));
		    	}else {
		        	player.sendMessage(" §c☠ §7"+deathmessage);
		    	}
		    }
		}
	    e.setDeathMessage(null); 
	}
	
	@SuppressWarnings("unchecked")
	private void spawnNPC(Player player) {
		NPCLibary npc = new NPCLibary(player.getLocation(), MathLibary.generateShortID());
		npc.setPing(NPCLibary.Ping.NO_CONNECTION);
		npc.spawnNPC((Collection<Player>) Bukkit.getOnlinePlayers());
		npc.setASyncSkinByUUID(Core.getPlugin(), (Collection<Player>) Bukkit.getOnlinePlayers(), player.getUniqueId());
		npc.setNameTagVisibility((Collection<Player>) Bukkit.getOnlinePlayers(), false);
		
		NPCLibary.NPCMetaData metaData = npc.getMetadata();
		metaData.setPose(NPCLibary.Pose.SLEEPING);
		npc.updateMetadata((Collection<Player>) Bukkit.getOnlinePlayers());
		Bukkit.getScheduler().runTaskLater(Core.getPlugin(), new Runnable() {
			@Override
			public void run() {
				npc.destroyNPC((Collection<Player>) Bukkit.getOnlinePlayers());
			}
	    },20*60*5);
	}
}
