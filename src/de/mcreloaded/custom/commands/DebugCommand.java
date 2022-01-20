package de.mcreloaded.custom.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import de.mcreloaded.core.Core;
import de.mcreloaded.custom.achievements.Achievements;
import de.mcreloaded.custom.items.ItemType;

public final class DebugCommand implements CommandExecutor, TabCompleter{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			/*
			try {
				new CustomItem(player.getItemInHand());
				player.sendMessage("True");
			}catch(CustomItemNotFoundExeption e) {
				player.sendMessage("False");
			}
			*/
			for(Achievements a : Achievements.values()) {
				Core.getPlugin().USERMANAGER.getProfile(player.getUniqueId()).giveAchievement(a);
			}
		
			player.getInventory().addItem(Core.getPlugin().ITEMMANAGER.getCustomItemByID(ItemType.IRONHAMMER).getItemStack());
			player.sendMessage(Core.getPlugin().ITEMMANAGER.getCustomItemByID(ItemType.IRONHAMMER).getItemStack().toString());
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

}
