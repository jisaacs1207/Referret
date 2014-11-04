package io.github.jisaacs1207.referret;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class referret extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("Referret is hooked!");
	}
 
	@Override
	public void onDisable() {
		getLogger().info("Referret is unhooked.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("referret"))||(cmd.getName().equalsIgnoreCase("ref"))||(cmd.getName().equalsIgnoreCase("refer"))) { // If the player typed /basic then do the following...
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "This command can only be run by a player.");
			}
			else {
				Player player = (Player) sender;
				
				// ---------------------------------- TIER 0 COMMAND BEGIN -----------------------------------------------------
				
				if (args.length == 0) {
					sender.sendMessage("");
					sender.sendMessage(ChatColor.GREEN + "The Five Kingdoms Referret");
					sender.sendMessage(ChatColor.GREEN + "Refer people to the 5K and earn rewards!");
					sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
					sender.sendMessage("");
				}
				
				// ---------------------------------- TIER 0 COMMAND END -----------------------------------------------------
				
				// ---------------------------------- TIER 1 COMMANDS BEGIN -----------------------------------------------------
				
				if (args.length == 1) {
					if (!args[0].equals("coupon")&&(!args[0].equals("help"))&&(!args[0].equals("info"))&&(!args[0].equals("top"))&&(!args[0].equals("gen"))) { // error
						sender.sendMessage(ChatColor.RED + "Sorry Mario, but your princess is in another castle!");
						sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
					}
					else if (args[0].equalsIgnoreCase("help")) {
						// help commands list (tier 1 of 2)
					}
					else if (args[0].equalsIgnoreCase("gen")) {
						// generate
					}
					else if (args[0].equalsIgnoreCase("info")) {
						// info on the player who ran the command (tier 1 of 2)
					}
					else if (args[0].equalsIgnoreCase("top")) {
						// help to list top based on week, month, and all-time (tier 1 of 2)
					}
					else if (args[0].equalsIgnoreCase("coupon")) {
						// help to redeem coupon
					}
					else{
						sender.sendMessage(ChatColor.RED + "Sorry Mario, but your princess is in another castle!"); // error
						sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
					}
				}
				// ---------------------------------- TIER 1 COMMANDS END -----------------------------------------------------
				
				// ---------------------------------- TIER 2 COMMANDS BEGIN --------------------------------------------------------
				
				if (args.length == 1) {
					if (!args[0].equals("coupon")&&(!args[0].equals("help"))&&(!args[0].equals("info"))&&(!args[0].equals("top"))&&(!args[0].equals("gen"))) { // error
						sender.sendMessage(ChatColor.RED + "Sorry Mario, but your princess is in another castle!");
						sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
					}
					
					// -----------------------------------T2 HELP --------------------------------------------------------------
					
					else if (args[0].equalsIgnoreCase("help")) {
						if (!args[1].equals("coupon")&&(!args[1].equals("help"))&&(!args[1].equals("info"))&&(!args[1].equals("top"))&&(!args[1].equals("gen"))) {
							sender.sendMessage(ChatColor.RED + "I am sorry but I cannot help you with that.");
							sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
						}
						else if (args[1].equalsIgnoreCase("help")) {
							// help on help... how redundant
						}
						else if (args[1].equalsIgnoreCase("gen")) {
							// help on generating codes
						}
						else if (args[1].equalsIgnoreCase("info")) {
							// help on info commands
						}
						else if (args[1].equalsIgnoreCase("top")) {
							// help on top commands
						}
						else if (args[1].equalsIgnoreCase("coupon")) {
							// help to redeem coupon
						}
						else{
							sender.sendMessage(ChatColor.RED + "I am sorry but I cannot help you with that.");
							sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
						}
					}
					// -----------------------------------T2 HELP END --------------------------------------------------------------
					
					// -----------------------------------T2 GEN -------------------------------------------------------------------
					else if (args[0].equalsIgnoreCase("gen")) {
						sender.sendMessage(ChatColor.YELLOW + "If you haven't generated a coupon yet, use '"+ ChatColor.LIGHT_PURPLE + "/referret gen"+ ChatColor.YELLOW + "'.");
						sender.sendMessage(ChatColor.YELLOW + "If you have generated a coupon yet, use '"+ ChatColor.LIGHT_PURPLE + "/referret info"+ ChatColor.YELLOW + "'.");
						sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
					}
					// -----------------------------------T2 GEN END-------------------------------------------------------------------
					
					// -----------------------------------T2 INFO  -------------------------------------------------------------------
					else if (args[0].equalsIgnoreCase("info")) {
						// other player info display only if admin or opped
					}
					
					// -----------------------------------T2 INFO END-------------------------------------------------------------------
					
					// -----------------------------------T2 TOP  -------------------------------------------------------------------
					
					else if (args[0].equalsIgnoreCase("top")) {
						if (args[1].equalsIgnoreCase("week")) {
							// displays top referrer of the week and reward
						}
						else if (args[1].equalsIgnoreCase("month")) {
							// displays top 3 referrer of the month and reward
						}
						else if (args[1].equalsIgnoreCase("alltime")) {
							// displays top 10 referrers of alltime and reward
						}
						else{
							sender.sendMessage(ChatColor.RED + "I am sorry but I cannot help you with that.");
							sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help top" + ChatColor.YELLOW + "' for command help.");
						}
					}
					
					// -----------------------------------T2 TOP END-------------------------------------------------------------------
					
					// -----------------------------------T2 COUPON  -------------------------------------------------------------------
					
					else if (args[0].equalsIgnoreCase("coupon")) {
						// redeems a specific code
					}
					
					// -----------------------------------T2 COUPON END-------------------------------------------------------------------
				}
				
				// ---------------------------------- TIER 2 COMMANDS END --------------------------------------------------------
				
			}
			return true;
		} 
		return false;
	}
}
