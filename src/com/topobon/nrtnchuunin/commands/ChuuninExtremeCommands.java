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
				ChuuninExam.startTimer(3);
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
				if (args[0].equalsIgnoreCase("numberOfContestants") && (ChuuninExam.isChuuninOn())) {

					try {
						if (Integer.valueOf(args[1]) == 4 || Integer.valueOf(args[1]) == 8) {

							ChuuninExam.setNumberOfContestants(Integer.valueOf(args[1]));
						} else {
							player.sendMessage(Utility.sendInfo("&4Please provide a proper number of 4 or 8!"));
						}
					} catch (Exception e) {
						player.sendMessage(Utility.sendInfo("&4Please provide a proper number of contestants!"));
						e.printStackTrace();
					}

				}
				if (args[0].equalsIgnoreCase("numberOfWinner") && (ChuuninExam.isChuuninOn())) {
					try {
						ChuuninExam.setNumberOfWinners((Integer.valueOf(args[1])));
					} catch (Exception e) {
						player.sendMessage(Utility.sendInfo("&4Please provide a proper number of winners!"));
						e.printStackTrace();
					}
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

