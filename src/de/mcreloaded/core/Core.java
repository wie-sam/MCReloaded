package de.mcreloaded.core;

import java.io.IOException;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.mcreloaded.custom.commands.DebugCommand;
import de.mcreloaded.custom.items.ItemManager;
import de.mcreloaded.datamanagment.LiteSQL;
import de.mcreloaded.datamanagment.cache.UserManager;
import de.mcreloaded.listener.player.PlayerConnect;
import de.mcreloaded.listener.player.PlayerDeath;
import de.mcreloaded.listener.player.PlayerInteract;

public class Core extends JavaPlugin{
	
	private static Core INSTANCE;
	
	public ItemManager ITEMMANAGER; 
	public LiteSQL LITESQL;
	public UserManager USERMANAGER;
	
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
		USERMANAGER = new UserManager();
		ITEMMANAGER = new ItemManager();
		
		init();
	}
	
	//Wenn der Plugin Deaktiviert wird, wird diese Methode ausgeführt.
	public void onDisable(){
		
		//Immer als letztes ausführen
		LITESQL.disconnect();
	}
	
	private final void init() {
		Bukkit.getOnlinePlayers().forEach(player -> {
			USERMANAGER.getProfile(player.getUniqueId());
		});
		
		getCommand("debug").setExecutor(new DebugCommand());
		
		Bukkit.getPluginManager().registerEvents(new PlayerConnect(), this);	
		Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);	
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);	
	}
	
	public static Core getPlugin() {
		return INSTANCE;
	}
}

