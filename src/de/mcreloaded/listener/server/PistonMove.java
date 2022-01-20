package de.mcreloaded.listener.server;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import de.mcreloaded.tools.ConsoleLogger;

public class PistonMove implements Listener {
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onExtend(BlockPistonExtendEvent e) {  
		
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onRetract(BlockPistonRetractEvent e) {  
		
	}
}
