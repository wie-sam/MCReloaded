package de.mcreloaded.datamanagment.cache;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import de.mcreloaded.tools.ConsoleLogger;

public class UserManager {
	
	private final ConcurrentHashMap<UUID, UserProfile> userprofilelist;
	
	public UserManager() {	
		this.userprofilelist = new ConcurrentHashMap<UUID, UserProfile>();
	
	}
	
	public final boolean loadProfile(UUID uuid) {	
		if(!userprofilelist.containsKey(uuid)) {
			UserProfile up = new UserProfile(uuid);
			userprofilelist.put(uuid, up);
			ConsoleLogger.debug("UserManager", "Loading profile for " + uuid.toString());
			return true;
		}
		return false;
	}
	
	public final boolean unloadProfile(UUID uuid) {	
		if(userprofilelist.containsKey(uuid)) {
			userprofilelist.remove(uuid);
			ConsoleLogger.debug("UserManager", "Unloading profile for " + uuid.toString());
			return true;
		}
		return false;
	}
	
	public final UserProfile getProfile(UUID uuid) {
		if(!userprofilelist.containsKey(uuid)) {
			return userprofilelist.get(uuid);
		}else {
			if(loadProfile(uuid)) {
				return userprofilelist.get(uuid);
			}
		}
		ConsoleLogger.debug("UserManager", "Hmm WTF how did this happend");
		return null;
	}	
	
	/*
	public final Collection<UserProfile> getProfiles(){
		return userprofilelist.values();
	}
	*/
	
}
