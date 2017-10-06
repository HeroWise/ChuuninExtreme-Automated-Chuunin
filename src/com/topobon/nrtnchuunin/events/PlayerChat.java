package com.topobon.nrtnchuunin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.topobon.nrtnchuunin.ChuuninExam;
import com.topobon.nrtnchuunin.ChuuninExtreme;
import com.topobon.nrtnchuunin.gameprocessing.GameManager;
import com.topobon.nrtnchuunin.gameprocessing.Participant;
import com.topobon.nrtnchuunin.utils.Utility;

public class PlayerChat implements Listener {
	static ChuuninExtreme instance;
	private int counterForPlayers = 0;

	public PlayerChat(ChuuninExtreme instance) {
		this.instance = instance;
	}

	@EventHandler
	public void onPlayerTalk(PlayerChatEvent event) {
		if (!ChuuninExam.isChuuninOn()) {
			counterForPlayers = 0;
		}

		if (ChuuninExam.isChuuninOn() && ChuuninExam.isChatOn()) {
			Player player = event.getPlayer();
			if (counterForPlayers <= ChuuninExam.getNumberOfContestants()) {
				if (event.getMessage().equalsIgnoreCase(ChuuninExam.getWord())) {
					if (ChuuninExam.getParticipantObject(player) != null) {
						// ChuuninExam.getParticipantObject(player).getPlayer()
						// .sendMessage(Utility.decodeMessage("&cYou are already
						// in Chuunin Exams!"));
						return;
					} else {
						Participant participant = new Participant(player);
						participant.setNumberOfRoundsWon(0);
						ChuuninExam.getParticipantList().add(participant);
						ChuuninExam.getFighting().clear();
						participant.getPlayer()
								.sendMessage(Utility.decodeMessage("&bYou have entered the Chuunin Exams!"));
						participant.getPlayer().teleport(ChuuninExam.getSpawnLocation());
						counterForPlayers++;
					}
				}
			}
			if (ChuuninExam.isChuuninOn() && ChuuninExam.isChatOn()
					&& counterForPlayers == ChuuninExam.getNumberOfContestants()) {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&l&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));

				Bukkit.broadcastMessage(Utility.sendInfo(
						"&c&l Chuunin Exams - Automated \n&b ◈  Multiple 1v1 and winner gets the title of Chuunin\n ◈  First to attain certain amount of wins, gains victory!"));
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&l&a▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬"));

				for (Participant participant : ChuuninExam.getParticipantList()) {
					participant.getPlayer().sendMessage(Utility.decodeMessage(("&b&lChuunin Exam &b has started! All "
							+ ChuuninExam.getNumberOfContestants() + " contestants have been picked!")));
					Player p = participant.getPlayer();

					p.sendMessage(
							ChatColor.translateAlternateColorCodes('&', "&8&m========&b&lChuunin Exams&8&m========"));

					p.sendMessage(Utility.decodeMessage("&c&lNo JTE/ATE"));
					p.sendMessage(Utility.decodeMessage("&aNo attacking while the target is trapped in an entomb."));
					p.sendMessage(Utility.decodeMessage("&c&lNo JTS/ATS"));
					p.sendMessage(Utility.decodeMessage("&aNo attacking while the target is trapped in a stun."));
					p.sendMessage(Utility.decodeMessage("&aThis rule also applies to spells such as:"));
					p.sendMessage(Utility.decodeMessage("&7Wind Scythe"));
					p.sendMessage(Utility.decodeMessage("&7Crystal Shuriken"));
					p.sendMessage(Utility.decodeMessage("&7Cloud Uprising"));

					p.sendMessage(Utility.decodeMessage("&7Desert Coffin"));
					p.sendMessage(Utility.decodeMessage("&7Tornado Blast"));
					p.sendMessage(Utility.decodeMessage("&7Rasengan"));
					p.sendMessage(Utility.decodeMessage("&8E.T.C"));
					p.sendMessage(Utility.decodeMessage(
							"&a&lThese spells do count as stuns and attacking while a player is hit by the spell is not allowed."));
					p.sendMessage(Utility.decodeMessage("&cNo RPGitem Glitching"));
					p.sendMessage(Utility.decodeMessage("&cNo holding a RPGitem while spells are active."));
					p.sendMessage(Utility.decodeMessage("&cE.G. using &7crystal frenzy&c and holding a RPGitem."));
					p.sendMessage(Utility.decodeMessage("&cOther common sense rules."));
					p.sendMessage(Utility.decodeMessage(
							"&cUse your brain and dont hack, cheat, or do anything that gives you an unfair illegal advantage.")); // Rules
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m==============================")); // here"

				}

				Bukkit.broadcastMessage(Utility.decodeMessage(("&bParticipants of Chuunin Exam:")));
				for (int i = 0; i < ChuuninExam.getNumberOfContestants(); i++) {

					Bukkit.broadcastMessage(Utility.decodeMessage(
							"&c&l◉&3 " + ChuuninExam.getParticipantList().get(i).getPlayer().getName() + ""));

				}
				Bukkit.broadcastMessage(Utility.decodeMessage("&b The fights will start in 2 mins!"));
				startTimer(4); // CHange
				// if Counter is maxed
				counterForPlayers = 0;
				ChuuninExam.setChatOn(false);

			}
		}
	}

	private static int time;

	public static void startTimer(int seconds) {
		time = seconds;

		new BukkitRunnable() {

			@Override
			public void run() {
				if (ChuuninExam.isChuuninOn()) {

				
					if (time == 0) {
						
						new GameManager(instance);
						
						
						this.cancel();
					}
					time--;
				} else {
					
					this.cancel();
				}

			}
		}.runTaskTimer(ChuuninExtreme.instance, 0, 20);

	}
}
