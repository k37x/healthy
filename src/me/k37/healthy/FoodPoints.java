package me.k37.healthy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FoodPoints implements CommandExecutor{
	
	


	//hearts
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Must be in game to initiate");
		return true;
		}
		Player player = (Player) sender;
		
		// FoodPoints
		
		if(cmd.getName().equalsIgnoreCase("FoodPoints") || cmd.getName().equalsIgnoreCase("fp")) {
			
			if(player.hasPermission("healthy.foodpoints") == true) {
				if (args.length == 0) {
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.YELLOW + "Nothing specified, defaulting to max food points");
					player.sendMessage(ChatColor.RED + "Please specify /foodpoints [player] [amount]");
					return true;
				}
				else if (args.length == 1) {
					if (player.getServer().getPlayer(args[0]) != null) {
						final Player targetPlayer = player.getServer().getPlayer(args[0]);
						targetPlayer.setFoodLevel(20);
						player.sendMessage(ChatColor.YELLOW + "Foodpoints adjusted for player");
						return true;
					}else {
						if (isNum(args[0])){
							int foodamt = Integer.parseInt(args[0]);
							if (foodamt >= 0 && foodamt <= 20) {
								
								player.setFoodLevel(foodamt);
								player.sendMessage(ChatColor.YELLOW + "No player specified, setting your food points...");
								return true;
							}else{
								player.sendMessage(ChatColor.RED + "Specify within 0-20");
								return true;
							}

						} else {
							player.sendMessage(ChatColor.RED + "Specify within 0-20");
							return true;
						}
					}
				}
			
				else if (args.length >= 2) {
					if (player.getServer().getPlayer(args[0]) != null) {
						
						if(isNum(args[1])) {
						final Player targetPlayer = player.getServer().getPlayer(args[0]);
						
						int foodamt = Integer.parseInt(args[1]);
						
						
						if (foodamt >= 0 && foodamt <= 20) {
							targetPlayer.setFoodLevel(foodamt);
							player.sendMessage(ChatColor.YELLOW + "Foodpoints adjusted for player");
							return true;
						}else {
							player.sendMessage(ChatColor.RED + "Specify within 0-20");
							return true;
						}
						} else {
							player.sendMessage(ChatColor.RED + "Specify within 0-20");
							return true;
						}
					
				}else {
					player.sendMessage(ChatColor.RED + "Player not online!");
					return true;
				}
			}
			}else {
				player.sendMessage(ChatColor.RED + "Execute Order Sixty Si....uh no permission!");
			}
			
			
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
