package com.topobon.nrtnchuunin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import com.topobon.nrtnchuunin.commands.ChuuninExtremeCommands;
import com.topobon.nrtnchuunin.events.PlayerChat;



public class ChuuninExtreme extends JavaPlugin {
	private static Logo ChuuninLogo;
	private static Logo NRTNLogo;
	private static Logo InfoLogo;
	public static ChuuninExtreme instance;

	public void onEnable() {
		instance = this;
		// Registering Commands
		this.getCommand("chuunin").setExecutor(new ChuuninExtremeCommands(this));
		// Registering Events
		Bukkit.getPluginManager().registerEvents(new PlayerChat(this), this);
		/**
		 * Creating new Logo Objects
		 */
		NRTNLogo = new Logo(ChatColor.translateAlternateColorCodes('&', "&7&l[&6&lNaruto &c&lRTN&7&l] &r"));
		ChuuninLogo = new Logo(ChatColor.translateAlternateColorCodes('&', "&8[&aChuunin&8] &r"));
		InfoLogo = new Logo(ChatColor.translateAlternateColorCodes('&', "&8&l[&6Info&8&l]&r"));
		setGameRules();
	
	}

	/**
	 * Method: <b> setGameRules() </b>
	 * <p>
	 * Sets Chuunin Rules, and its job is to:
	 * </p>
	 * <ul>
	 * <li>Set words in word List
	 * <{@code ChuuninExam#setWordsInList(String...)}>
	 */
	public void setGameRules() {
		// Set World
		World world = Bukkit.getWorld("world");
		// Set Words in ArrayLIst
		ChuuninExam.setWordsInList("SpaceCat", "Reported");
		// Set Location
		ChuuninExam.setLocationA(new Location(world, 1, 4, 3));
		ChuuninExam.setLocationB(new Location(world, 1, 4, 3));
		ChuuninExam.setSpawnLocation(new Location(world, 1, 2, 2));
		ChuuninExam.setNumberOfContestants(1);
		ChuuninExam.setNumberOfWinners();

	}

	// Logo Object Manager
	public static Logo getChuuninLogo() {
		return ChuuninExtreme.ChuuninLogo;
	}

	public static Logo getNRTNLogo() {
		return ChuuninExtreme.NRTNLogo;
	}

	public static Logo getInfoLogo() {
		return ChuuninExtreme.InfoLogo;

	}
}
