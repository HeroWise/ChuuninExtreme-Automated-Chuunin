package com.topobon.nrtnchuunin;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.topobon.nrtnchuunin.gameprocessing.Participant;
import com.topobon.nrtnchuunin.utils.Utility;

public class ChuuninExam {
	private static ArrayList<String> wordLists = new ArrayList<String>();

	private static ArrayList<Participant> participants = new ArrayList<Participant>();
	private static ArrayList<Participant> fighting = new ArrayList<Participant>();
	private static Location locationA;
	private static Location locationB;
	private static Location spawnLocation;
	private static boolean isChuuninOn;
	private static boolean isChatOn;
	private static String wordOfTheGame;
	private static int numberOfContestants;
	private static int numberOfPointsToWin;

	public static ArrayList<String> getWordLists() {
		return wordLists;
	}

	private static String generateRandomWord() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(wordLists.size());

		return wordLists.get(randomNumber);

	}

	// Chuunin State Modifier
	/**
	 * Method: <b> startGame() </b>
	 * <p>
	 * Starts Chuunin Match
	 * </p>
	 * <ul>
	 * <li>Set words in word List
	 * <{@code ChuuninExam#setWordsInList(String...)}>
	 */
	public static void startGame() {
		ChuuninExam.setChuuninOn(true);
		ChuuninExam.setChatOn(true);
		wordOfTheGame = generateRandomWord();
		System.out.println(wordOfTheGame);
		participants.clear();
		fighting.clear();
	}

	/**
	 * Method: <b> stopGame() </b>
	 * <p>
	 * Sets Chuunin Rules, and its job is to: </b>
	 * <ul>
	 * <li>Set words in word List
	 * <{@code ChuuninExam#setWordsInList(String...)}>
	 */
	public static void stopGame() {
		ChuuninExam.setChuuninOn(false);
		ChuuninExam.setChatOn(false);
		wordOfTheGame = null;
		participants.clear();
		fighting.clear();

	}

	public static ArrayList<Participant> getParticipantList() {
		return participants;
	}

	public static ArrayList<Participant> getFighting() {
		return fighting;
	}

	public static Participant getParticipantObject(Player player) {
		for (Participant p : getParticipantList()) {
			if (p.getPlayer().equals(player)) {
				return p;
			}
		}
		return null;
	}

	public static String getWord() {
		return wordOfTheGame;
	}

	public static void setWordsInList(String... wordsToBeAdded) {
		for (String s : wordsToBeAdded) {
			wordLists.add(s);
		}
	}

	public static Location getLocationA() {
		return locationA;
	}

	public static void setLocationA(Location locationA) {
		ChuuninExam.locationA = locationA;
	}

	public static Location getLocationB() {
		return locationB;
	}

	public static void setLocationB(Location locationB) {
		ChuuninExam.locationB = locationB;
	}

	public static Location getSpawnLocation() {
		return spawnLocation;
	}

	public static void setSpawnLocation(Location spawnLocation) {
		ChuuninExam.spawnLocation = spawnLocation;
	}

	public static boolean isChuuninOn() {
		return isChuuninOn;
	}

	public static void setChuuninOn(boolean isChuuninOn) {
		ChuuninExam.isChuuninOn = isChuuninOn;
	}

	public static boolean isChatOn() {
		return isChatOn;
	}

	public static void setChatOn(boolean isChatOn) {
		ChuuninExam.isChatOn = isChatOn;
	}

	public static int getNumberOfContestants() {
		return numberOfContestants;
	}

	public static void setNumberOfContestants(int numberOfContestants) {
		ChuuninExam.numberOfContestants = numberOfContestants;
	}

	private static int time;
	// private static int counter = 1;

	public static void startTimer(int seconds) {
		time = seconds;

		// System.out.println("Cancelling task because counter is: " + counter);
		new BukkitRunnable() {

			@Override
			public void run() {
				if (isChuuninOn) {

					if (time == 3) {
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&l3"));
					}
					if (time == 2) {
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6&l2"));
					}
					if (time == 1) {
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4&l1"));
					}
					if (time == 0) {
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2&lGO!"));

						this.cancel();
					}
					time--;
				} else {
					this.cancel();
				}

			}
		}.runTaskTimer(ChuuninExtreme.instance, 0, 20);

	}

	public static void setNumberOfWinners(int numberOfWinner) {
		// FIX TODO
		if (getNumberOfContestants() == 4) {
			if (numberOfWinner == 1) {
				setNumberOfPointsToWin(2);

			}
			if (numberOfWinner == 2) {
				setNumberOfPointsToWin(1);

			}
		}
		if (getNumberOfContestants() == 2) {
			if (numberOfWinner == 1) {
				setNumberOfPointsToWin(1);

			}
			if (numberOfWinner == 2) {
				setNumberOfPointsToWin(1);

			}
		}
		// Going with this
		if (getNumberOfContestants() == 8) {
			// Going with this
			if (numberOfWinner == 1) {
				setNumberOfPointsToWin(3);

			}
			if (numberOfWinner == 2) {
				setNumberOfPointsToWin(2);

			}
		}

	}

	public static int getNumberOfPointsToWin() {
		return numberOfPointsToWin;
	}

	public static void setNumberOfPointsToWin(int numberOfPointsToWin) {
		ChuuninExam.numberOfPointsToWin = numberOfPointsToWin;
	}

}
