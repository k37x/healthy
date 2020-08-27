package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyHearts implements CommandExecutor{
	
	


	//myhearts
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// hearts
		
		if(cmd.getName().equalsIgnoreCase("MyHearts") || cmd.getName().equalsIgnoreCase("ht")) {
			if(player.hasPermission("healthy.myhearts") == true) {
				

				if (args.length == 0) {
					player.sendMessage(ChatColor.YELLOW + "Hearts set to 20.");
					player.setHealth(20);
					return true;
				}else if (args.length == 1) {
					
					if(isNum(args[0])) {
				
					double healthspec = Integer.parseInt(args[0]);
					if (healthspec >= 0 && healthspec <= 20) {
					
						player.setHealth(healthspec);
						player.sendMessage(ChatColor.YELLOW + "Hearts adjusted for player");
						return true;
					}else {
						player.sendMessage(ChatColor.RED + "Please specify amount between [0-20]");
						return true;
					}
					}
				
				
			}
			}else {
				player.sendMessage(ChatColor.RED + "Execute Order Sixty Si....uh no permission!");
			}
			
		return true;
		
		}
	
	return true;
	
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
			} catch (NumberFormatException ex) {
				
				return false;
				
			}
		return true;
	}
	

}


