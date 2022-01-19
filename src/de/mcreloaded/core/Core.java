package de.mcreloaded.core;

import java.io.IOException;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.mcreloaded.custom.commands.DebugCommand;
import de.mcreloaded.custom.items.ItemManager;
import de.mcreloaded.datamanagment.LiteSQL;

public class Core extends JavaPlugin{
	
	private static Core INSTANCE;
	
	public ItemManager ITEMMANAGER; 
	public LiteSQL LITESQL;
	
	//Wenn der Plugin Aktiviert wird, wird diese Methode ausgeführt.
	public void onEnable() {
		INSTANCE = this;
		
		//Versucht eine verbindung mit der Datenbank zu verbinden. Falls nicht dann wird das plugin deaktiviert! 
		try {
			LITESQL = new LiteSQL();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
		ITEMMANAGER = new ItemManager();
		
		initCommands();
	}
	
	//Wenn der Plugin Deaktiviert wird, wird diese Methode ausgeführt.
	public void onDisable(){
		
	}
	
	private final void initCommands() {
		getCommand("debug").setExecutor(new DebugCommand());
	}
	
	public static Core getPlugin() {
		return INSTANCE;
	}
}

