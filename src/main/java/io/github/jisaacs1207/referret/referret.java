package io.github.jisaacs1207.referret;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class referret extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("Referret is hooked!");
		saveDefaultConfig();
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
						sender.sendMessage("");
						sender.sendMessage(ChatColor.GREEN + "The Five Kingdoms Referret Help");
						sender.sendMessage(ChatColor.GREEN + "");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "/referret help <command>" + ChatColor.YELLOW + " - Individual command help");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "/referret gen" + ChatColor.YELLOW + " - Generate a referral code for you to share");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "/referret info" + ChatColor.YELLOW + " - Displays your code and other useful info");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "/referret top [w/m/a]" + ChatColor.YELLOW + " - Lists top referrers (w=weekly)");
						sender.sendMessage(ChatColor.LIGHT_PURPLE + "/referret coupon <code>" + ChatColor.YELLOW + " - Redeems someones referral code");
						sender.sendMessage("");
					}
					else if (args[0].equalsIgnoreCase("gen")) {
						Random rand = new Random();
						if(getConfig().getString(player.getName().toLowerCase()+".code")==null){
							char initialOne = player.getName().toLowerCase().charAt(0);
							char initialTwo = player.getName().toLowerCase().charAt(1);
							int rndOne = rand.nextInt(9 - 1 + 1) + 1;
							int rndTwo = rand.nextInt(9 - 1 + 1) + 1;
							int rndThree = rand.nextInt(9 - 1 + 1) + 1;
							int rndFour = rand.nextInt(9 - 1 + 1) + 1;
							String code = String.valueOf(initialOne)+String.valueOf(initialTwo)+String.valueOf(rndOne)+String.valueOf(rndTwo)+String.valueOf(rndThree)+String.valueOf(rndFour);
							getConfig().set(player.getName().toLowerCase()+".code", code );
							player.sendMessage("");
							player.sendMessage(ChatColor.GREEN + "Your new referral code is " + code + "!");
							player.sendMessage(ChatColor.GREEN + "Share this on forums, Youtube, Facebook, or anywhere else!");
							player.sendMessage(ChatColor.GREEN + "For every referral, you gain shop points and cash!");
							player.sendMessage("");
							sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret info" + ChatColor.YELLOW + "' if you forget!");
							this.saveConfig();
						}
						else player.sendMessage("You've already got a code. Check it with '/referret info'!");
					}
					else if (args[0].equalsIgnoreCase("info")) {
						int refPlayers = 0;
						String code = "You don't have one!";
						if(getConfig().getString(player.getName().toLowerCase()+".referred")!=null){
							refPlayers = getConfig().getInt(player.getName().toLowerCase()+".pReferred");
						}
						if(getConfig().getString(player.getName().toLowerCase()+".code")!=null){
							code = getConfig().getString(player.getName().toLowerCase()+".code");
						}
						sender.sendMessage("");
						sender.sendMessage(ChatColor.GREEN + "Your Five Kingdoms Referret Info");
						sender.sendMessage("");
						sender.sendMessage(ChatColor.YELLOW + "Your referral code is : " + code);
						sender.sendMessage(ChatColor.YELLOW + "Players referred : " + refPlayers);
						sender.sendMessage("");
					}
					else if (args[0].equalsIgnoreCase("top")) {
						// help to list top based on week, month, and all-time (tier 1 of 2)
					}
					else if (args[0].equalsIgnoreCase("coupon")) {
						sender.sendMessage(ChatColor.RED + "You need to include a coupon code!");
						sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help coupon" + ChatColor.YELLOW + "' for command help.");
					}
					else{
						sender.sendMessage(ChatColor.RED + "Sorry Mario, but your princess is in another castle!"); // error
						sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help" + ChatColor.YELLOW + "' for command help.");
					}
				}
				// ---------------------------------- TIER 1 COMMANDS END -----------------------------------------------------
				
				// ---------------------------------- TIER 2 COMMANDS BEGIN --------------------------------------------------------
				
				if (args.length == 2) {
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
							sender.sendMessage("");
							sender.sendMessage(ChatColor.GREEN + "Your Five Kingdoms Help Help");
							sender.sendMessage("");
							sender.sendMessage(ChatColor.YELLOW + "Okay. We can play this game. Ready?");
							sender.sendMessage(ChatColor.YELLOW + "Help helps you help while helping help help the helpless.");
							sender.sendMessage(ChatColor.YELLOW + "Help cannot be expected to help helping help help help,");
							sender.sendMessage(ChatColor.YELLOW + "if much help is needed; This includes helping helping help");
							sender.sendMessage(ChatColor.YELLOW + "the helplessly helpful. Helping help is strictly forbidden");
							sender.sendMessage(ChatColor.YELLOW + "in cases of helping help heedlessly or unhelpfully. Help");
							sender.sendMessage(ChatColor.YELLOW + "help helpfully, heedfully, and help when help is needed.");
							sender.sendMessage("");
						}
						else if (args[1].equalsIgnoreCase("gen")) {
							sender.sendMessage("");
							sender.sendMessage(ChatColor.GREEN + "Your Five Kingdoms Generator Help");
							sender.sendMessage("");
							sender.sendMessage(ChatColor.YELLOW + "Using the command '/referret gen' will give assign");
							sender.sendMessage(ChatColor.YELLOW + "you a special coupon code that can be used by anyone");
							sender.sendMessage(ChatColor.YELLOW + "once. Upon using your code, they will receive a basic");
							sender.sendMessage(ChatColor.YELLOW + "machine kit. You will receive points towards our web");
							sender.sendMessage(ChatColor.YELLOW + "store. You can find our shop at the following url:");
							sender.sendMessage(ChatColor.GREEN + "          http://fivekingdoms.net/shop");
							sender.sendMessage("");
						}
						else if (args[1].equalsIgnoreCase("info")) {
							sender.sendMessage("");
							sender.sendMessage(ChatColor.GREEN + "Your Five Kingdoms Info Help");
							sender.sendMessage("");
							sender.sendMessage(ChatColor.YELLOW + "The '/referret info' command will let you know several");
							sender.sendMessage(ChatColor.YELLOW + "important statistics about your referral count. This");
							sender.sendMessage(ChatColor.YELLOW + "includes your winner status in our top list, your");
							sender.sendMessage(ChatColor.YELLOW + "coupon code, as well as your current referral number.");
							sender.sendMessage("");
						}
						else if (args[1].equalsIgnoreCase("top")) {
							sender.sendMessage("");
							sender.sendMessage(ChatColor.GREEN + "Your Five Kingdoms Top Help");
							sender.sendMessage("");
							sender.sendMessage(ChatColor.YELLOW + "The following commands/lists are available to view:");
							sender.sendMessage(ChatColor.YELLOW + "");
							sender.sendMessage(ChatColor.YELLOW + "/referret top w - Lists the weekly top referrers.");
							sender.sendMessage(ChatColor.YELLOW + "/referret top m - Lists the monthly top referrers.");
							sender.sendMessage(ChatColor.YELLOW + "/referret top a - Lists the all-time top referrers.");
							sender.sendMessage(ChatColor.YELLOW + "/referret top - Lists the top referrer of each category.");
							sender.sendMessage("");
						}
						else if (args[1].equalsIgnoreCase("coupon")) {
							sender.sendMessage("");
							sender.sendMessage(ChatColor.GREEN + "Your Five Kingdoms Coupon Help");
							sender.sendMessage("");
							sender.sendMessage(ChatColor.YELLOW + "The '/referret coupon' command must be used with a valid");
							sender.sendMessage(ChatColor.YELLOW + "referral code. For example, the following syntax works: ");
							sender.sendMessage(ChatColor.YELLOW + "/referret coupon ji8321");
							sender.sendMessage(ChatColor.YELLOW + "");
							sender.sendMessage(ChatColor.YELLOW + "You will receive a basic machine kit for redeeming a");
							sender.sendMessage(ChatColor.YELLOW + "coupon code, as well as helping your referrer out! You");
							sender.sendMessage(ChatColor.YELLOW + "may only claim a coupon one time.");
							sender.sendMessage("");
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
						if(player.isOp()){
							int refPlayers = 0;
							String code = "none";
							String name = args[1].toLowerCase();
							if(getConfig().getConfigurationSection(name)!=null){
								if(getConfig().getString(name.toLowerCase()+".code")!=null){
									code = getConfig().getString(name.toLowerCase()+".code");
								}
								if(getConfig().getString(name.toLowerCase()+".pReferred")!=null){
									refPlayers = getConfig().getInt(name.toLowerCase()+".pReferred");
								}
								sender.sendMessage("");
								sender.sendMessage(ChatColor.GREEN + args[1] + "'s Five Kingdoms Referret Info");
								sender.sendMessage("");
								sender.sendMessage(ChatColor.YELLOW + "Their referral code is : " + code);
								sender.sendMessage(ChatColor.YELLOW + "Their players referred : " + refPlayers);
								sender.sendMessage("");
							}
							else player.sendMessage(ChatColor.RED + "Sorry, but there are no records for that player.");
						}
					}
					
					// -----------------------------------T2 INFO END-------------------------------------------------------------------
					
					// -----------------------------------T2 TOP  -------------------------------------------------------------------
					
					else if (args[0].equalsIgnoreCase("top")) {
						if (args[1].equalsIgnoreCase("w")) {
							// displays top referrer of the week and reward
						}
						else if (args[1].equalsIgnoreCase("m")) {
							// displays top 3 referrer of the month and reward
						}
						else if (args[1].equalsIgnoreCase("a")) {
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
						String code = args[1];
						boolean foundCode = false;
						int pReferred = 0;
						String referrer = null;
						if(code.length()==6){
							for(String name: getConfig().getKeys(false)){
								if(getConfig().getString(name+".code").equalsIgnoreCase(code)){
									foundCode=true;
									if(getConfig().getString(name+".pReferred")!=null){
										pReferred = getConfig().getInt(name+".pReferred");
										pReferred = pReferred + 1;
										getConfig().set(name+".pReferred", pReferred);
									}
									else{
										getConfig().set(name+".pReferred", 1);
									}
									referrer = name;
									getConfig().set(player.getName().toLowerCase()+".referredBy", name);
									Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mail send " + referrer + " " + player.getName() + " has joined with your referret code!");
									for(Player onlineP : Bukkit.getOnlinePlayers()) {
									    if(onlineP.getName().equalsIgnoreCase(referrer)){
									    	onlineP.sendMessage(ChatColor.GREEN + player.getName() + " has chosen you as their referrer!");
									    }
									}
									this.saveConfig();
								}
							}
							if(foundCode){
								sender.sendMessage("Thanks for redeeming, enjoy your new stuff!");
								sender.sendMessage("We've also thanked " + referrer + " for referring you!");
							}
							else{
								sender.sendMessage(ChatColor.RED + "I am sorry but that is an invalid coupon.");
								sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help coupon" + ChatColor.YELLOW + "' for command help.");
							}
						}
						else{
							sender.sendMessage(ChatColor.RED + "I am sorry but that is an invalid coupon.");
							sender.sendMessage(ChatColor.YELLOW + " Type '" + ChatColor.LIGHT_PURPLE + "/referret help coupon" + ChatColor.YELLOW + "' for command help.");
						}
						
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
