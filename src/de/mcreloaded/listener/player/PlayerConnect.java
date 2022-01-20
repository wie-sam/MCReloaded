package de.mcreloaded.listener.player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.mcreloaded.Utils;
import de.mcreloaded.core.Core;

public class PlayerConnect implements Listener {

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if(!Core.getPlugin().LITESQL.isConnected()) {
			e.disallow(Result.KICK_OTHER, "§cDATABASE_DECODE_ERROR");
			return;
		}
		
		if(Utils.doesPlayerExistInDB(p.getUniqueId())){
			try {
				PreparedStatement ps = Core.getPlugin().LITESQL.getConnection().prepareStatement("UPDATE `playerdata` SET `ipadresse` = ? WHERE `uuid` = ?");
				ps.setString(1, e.getAddress().getHostAddress());
				ps.setString(2, p.getUniqueId().toString());
				ps.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}else {
			try {
				PreparedStatement ps = Core.getPlugin().LITESQL.getConnection().prepareStatement("INSERT INTO playerdata (uuid,ipadresse) VALUES (?,?)");
				ps.setString(1, p.getUniqueId().toString());
				ps.setString(2, e.getAddress().getHostAddress());
				ps.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		Core.getPlugin().USERMANAGER.loadProfile(e.getPlayer().getUniqueId());
	}

}
