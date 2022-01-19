package de.mcreloaded.datamanagment.cache;

import java.util.ArrayList;
import java.util.UUID;

import de.mcreloaded.custom.achievements.Achievement;
import de.mcreloaded.custom.achievements.Achievements;

public class UserProfile {
	
	private final UUID uuid;
	private ArrayList<Achievement> achievementlist;
	
	
	public UserProfile(UUID uuid) {
		this.uuid = uuid;
		this.achievementlist = new ArrayList<Achievement>();
	}
	
	public boolean giveAchievement(Achievements achievement) {
		
	}
	
	public boolean hasAchievement(Achievements achievement) {
		for(Achievement a : achievementlist) {
			if(a.getAchievement().equals(achievement)) {
				return true;
			}
		}
		return false;
	}
	
	public final UUID getPlayerUUID() {
		return this.uuid;
	}
	
	public final ArrayList<Achievement> getAchievementList(){
		return this.achievementlist;
	}
}
