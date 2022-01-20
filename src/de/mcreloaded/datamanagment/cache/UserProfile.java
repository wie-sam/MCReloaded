package de.mcreloaded.datamanagment.cache;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.mcreloaded.core.Core;
import de.mcreloaded.custom.achievements.AchievementCache;
import de.mcreloaded.custom.achievements.Achievements;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class UserProfile {
	
	private final UUID uuid;
	private final ArrayList<AchievementCache> achievementlist;
	
	private BlockFace lastblockface;
	
	private final int databaseid;
	
	public UserProfile(UUID uuid) throws Exception{
		this.uuid = uuid;
		this.achievementlist = new ArrayList<AchievementCache>();
		
		//Loads the player data from the database
		ResultSet playerdata = Core.getPlugin().LITESQL.onQuery("SELECT PK_Playerdata_ID FROM playerdata WHERE uuid = '" + uuid.toString()+"'");
		playerdata.next();
		this.databaseid = playerdata.getInt("PK_Playerdata_ID");

		ResultSet achievments = Core.getPlugin().LITESQL.onQuery("SELECT * FROM achievements WHERE FK_Playerdata_ID = " + databaseid);
		while (achievments.next()) {
			Achievements a;
			if ((a = Achievements.getFromDatabaseID(achievments.getInt("achievementid"))) != null) {
				achievementlist.add(new AchievementCache(a, achievments.getLong("timeclaimed")));
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public final boolean giveAchievement(Achievements achievement) {
		if(!hasAchievement(achievement)) {
			try {
				PreparedStatement ps = Core.getPlugin().LITESQL.getConnection().prepareStatement("INSERT INTO achievements(FK_Playerdata_ID,achievementid,timeclaimed) VALUES (?,?,?)");
				ps.setInt(1, databaseid);
				ps.setInt(2, achievement.getDatabaseID());
				ps.setLong(3, System.currentTimeMillis());
				ps.executeUpdate();
				
				achievementlist.add(new AchievementCache(achievement, System.currentTimeMillis()));
		
				Player player;
				if((player = Bukkit.getPlayer(uuid)) != null) {
					TextComponent tc_achievement = new TextComponent("§a§k0§a>> Achievment Unlocked: §6"+achievement.getName()+" §a<<§k0");
					//tc_achievement.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, "/profile loadgui/achievements/" ));
					tc_achievement.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§a"+achievement.getText()).create()));	
					player.spigot().sendMessage(tc_achievement);
					player.playSound(player.getEyeLocation(), Sound.BLOCK_NOTE_BLOCK_BIT,SoundCategory.MASTER, 1, 4.0f);	
				}
				return true;
			}catch(SQLException e) {
				e.printStackTrace();
			}
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
