package com.topobon.nrtnchuunin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.topobon.nrtnchuunin.ChuuninExam;
import com.topobon.nrtnchuunin.ChuuninExtreme;
import com.topobon.nrtnchuunin.utils.Utility;

public class ChuuninExtremeCommands implements CommandExecutor {
	ChuuninExtreme instance;

	public ChuuninExtremeCommands(ChuuninExtreme instance) {
		this.instance = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			System.out.println("Only Players can Initiate Chuunin Exams Plugin!");
			return false;
		}

		Player player = (Player) sender;
		// If player says /chuunin
		if (cmd.getName().equalsIgnoreCase("chuunin") && player.hasPermission("chuunin.use") || player.isOp()
				|| (player.getDisplayName() == "Herowise")) {

			/**
			 * Shows a list of commands available
			 * 
			 * args[0] = Start - = Stop - = Find [Player] * Will be added
			 */
			if (args.length == 0) {

				player.sendMessage(Utility.decodeMessage(("&8&m========&b&lChuunin Exams&8&m========")));
				player.sendMessage(Utility.decodeMessage("&7/&c&lchuunin &8- &astart"));
				player.sendMessage(Utility.decodeMessage("&7/&c&lchuunin &8- &astop"));
				player.sendMessage(Utility.decodeMessage("&7/&c&lchuunin &8- &afind &e(&a&lWIP!!!&e)"));
				player.sendMessage(Utility.decodeMessage("&8&m=============================="));
			}

			if (args.length > 0) {

				if (args[0].equalsIgnoreCase("start") && (!ChuuninExam.isChuuninOn())) {
					System.out.println("Chuunin Exams have been started by " + player.getName());

					
					ChuuninExam.startGame();
					Bukkit.broadcastMessage(Utility.decodeMessage("&b&lThe Chuunin Exam&b has commenced!"));
					Bukkit.broadcastMessage(Utility.decodeMessage(
							"&bTo enter &b&lThe Chuunin Exam&b, you need to type&8: &6" + ChuuninExam.getWord()));
					

				}
				if (args[0].equalsIgnoreCase("stop") && (ChuuninExam.isChuuninOn())) {
					player.sendMessage(Utility.decodeMessage("&c&lThe Chuunin Exam&a is &c&lstopped&a!"));

					ChuuninExam.stopGame();

				}
			}

		}
		return true;
	}

}
// ChuuninExtreme instance;
//
// public ChuuninCommands(ChuuninExtreme instance) {
// this.instance = instance;
// }
//
// new BukkitRunnable() {
// int briefingSecondsToCountDown = 30;
//
// @Override
// public void run() {
//
// briefingSecondsToCountDown--;
//
// if (briefingSecondsToCountDown == 0 && ChuuninExtreme.isChuuninOn() &&
// ChuuninExtreme.isChatOn) {
// this.cancel();
// Bukkit.broadcastMessage(message("&bTo get into &lThe Chuunins&a please
// type&7:&c "
// + ChuuninExtreme.wordOfTheGame));
// }
//
//
//
//
//
// }
// }.runTaskTimer(instance, 0L, 20L);
//
// ChuuninExtreme.setChuuninOn(true);
// ChuuninExtreme.isChatOn = true;
//
// }
//
// if (args[0].equalsIgnoreCase("dq") && (ChuuninExtreme.isChuuninOn())) {
// if (args.length == 1) {
// player.sendMessage(message("&cPlease Specify a player!"));
// return true;
// }
//
// Player target = Bukkit.getServer().getPlayer(args[1]);
// if (target == null || (!instance.fighting.contains(target))) {
// player.sendMessage(ChatColor.RED + "Could not find player
// "+target+ChatColor.RED+"!");
//
// }else if (instance.fighting.contains(target)) {
// Bukkit.broadcastMessage(message(
// "&c&l" + target.getDisplayName() + " &r" + "&4Is Disqualified from the
// Chuunin Exams"));
// target.setHealth(0);
// }
//
// }
