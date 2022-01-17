package de.mcreloaded;

import org.bukkit.Bukkit;

public final class Utils {
	
	//Überprüft ob die version des Servers eine minecraft version ist 
	public static final boolean isRunningMinecraft(int major, int minor, int revision) {
		String[] version = Bukkit.getServer().getBukkitVersion().split("-")[0].split("\\.");
		int maj = Integer.parseInt(version[0]);
		int min = Integer.parseInt(version[1]);
		int rev;
		try {
			rev = Integer.parseInt(version[2]);
		} catch (Exception ignore) {
			rev = 0;
		}
		return maj > major || min > minor || (min == minor && rev >= revision);
	}

	//Checkt ob der Server ist Spigot Based
	public static final boolean isRunningSpigot() {
		return classExists("org.spigotmc.CustomTimingsHandler");
	}

	public static final boolean classExists(final String className) {
		try {
			Class.forName(className);
			return true;
		} catch (ClassNotFoundException ex) {
			return false;
		}
	}
}
