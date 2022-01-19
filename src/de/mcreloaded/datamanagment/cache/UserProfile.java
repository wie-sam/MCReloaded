package de.mcreloaded.datamanagment.cache;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.block.BlockFace;

import com.mysql.jdbc.PreparedStatement;

import de.mcreloaded.core.Core;
import de.mcreloaded.custom.achievements.AchievementCache;
import de.mcreloaded.custom.achievements.Achievements;
import de.mcreloaded.datamanagment.LiteSQL;

public class UserProfile {
	
	private final UUID uuid;
	private ArrayList<AchievementCache> achievementlist;
	
	private BlockFace lastblockface;
	
	public UserProfile(UUID uuid) {
		this.uuid = uuid;
		this.achievementlist = new ArrayList<AchievementCache>();
	}
	
	public final boolean giveAchievement(Achievements achievement) {
		if(!hasAchievement(achievement)) {
			//PreparedStatement ps = Core.getPlugin().LITESQL.getConnection().prepareStatement(" "+1);
			//ps.setInt(1, 1);
		
			//ps.executeUpdate();
		}
		return false;
	}
	
	public final boolean hasAchievement(Achievements achievement) {
		for(AchievementCache a : achievementlist) {
			if(a.getAchievement().equals(achievement)) {
				return true;
			}
		}
		return false;
	}
	
	public final UUID getPlayerUUID() {
		return this.uuid;
	}
	
	public final ArrayList<AchievementCache> getAchievementList(){
		return this.achievementlist;
	}
	
	public final void setLastBlockFace(BlockFace lastblockface) {
		this.lastblockface = lastblockface;
	}
	
	public final BlockFace getLastBlockFace() {
		return this.lastblockface;
	}
}
