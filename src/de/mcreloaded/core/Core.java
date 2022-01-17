package de.mcreloaded.core;

import org.bukkit.plugin.java.JavaPlugin;

import de.mcreloaded.custom.commands.DebugCommand;
import de.mcreloaded.custom.items.ItemManager;

public class Core extends JavaPlugin{
	
	private static Core INSTANCE;
	
	public ItemManager ITEMMANAGER; 
	
	//Wenn der Plugin Aktiviert wird, wird diese Methode ausgeführt.
	public void onEnable() {
		System.out.println("Hello World");
		
		INSTANCE = this;
		ITEMMANAGER = new ItemManager();
		
		getCommand("debug").setExecutor(new DebugCommand());
	}
	
	//Wenn der Plugin Deaktiviert wird, wird diese Methode ausgeführt.
	public void onDisable(){
		System.out.println("Bye World");
	}
	
	public static Core getPlugin() {
		return INSTANCE;
	}
}

