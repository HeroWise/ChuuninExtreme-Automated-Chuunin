package com.topobon.nrtnchuunin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ChuuninExtreme extends JavaPlugin {
	private static Logo ChuuninLogo;
	private static Logo NRTNLogo;
	private static Logo InfoLogo;

	public void onEnable() {
		/**
		 * Creating new Logo Objects
		 */
		NRTNLogo = new Logo(ChatColor.translateAlternateColorCodes('&', "&7&l[&6&lNaruto &c&lRTN&7&l] &r"));
		ChuuninLogo = new Logo(ChatColor.translateAlternateColorCodes('&', "&7&l[&3&lChuunin&7&l] &r"));
		InfoLogo = new Logo(ChatColor.translateAlternateColorCodes('&', "&8&l[&6Info&8&l]&r"));
		
		
	}

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
