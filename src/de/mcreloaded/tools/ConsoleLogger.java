package de.mcreloaded.tools;

import org.bukkit.Bukkit;

import de.mcreloaded.core.Constants;

public final class ConsoleLogger {

	/*
	 * Diese klasse ist dafür da um nachrichten verschidender dringigkeit 
	 * in der Konsole an zuzeigen.
	 */
	
	// info
	public static void info(Object className, Object message) {
		Bukkit.getConsoleSender().sendMessage("[Info] " + className + " : " + message);
	}

	public static void info(Object message) {
		Bukkit.getConsoleSender().sendMessage("[Info] : " + message);
	}

	// error
	public static void error(Object className, Object message) {
		Bukkit.getConsoleSender().sendMessage("[Error] " + className + " : " + message);
	}

	public static void error(Object message) {
		Bukkit.getConsoleSender().sendMessage("[Error] : " + message);
	}

	// debug
	public static void debug(Object className, Object message) {
		if (Constants.DEBUGMODE) {
			Bukkit.getConsoleSender().sendMessage("[Debug] " + className + " : " + message);
		}
	}

	public static void debug(Object message) {
		if (Constants.DEBUGMODE) {
			Bukkit.getConsoleSender().sendMessage("[Debug] : " + message);
		}
	}

	// warning
	public static void warning(Object className, Object message) {
		Bukkit.getConsoleSender().sendMessage("[Warning] " + className + " : " + message);
	}

	public static void warning(Object message) {
		Bukkit.getConsoleSender().sendMessage("[Warning] : " + message);
	}
	
	public enum ConsoleLoggerNames{
		LITESQL("LiteSQL");
		
		private final String name;
		
		ConsoleLoggerNames(String name) {
			this.name = name;
		}
		
		public final String getDisplayName() {
			return this.name;
		}
	}
}
