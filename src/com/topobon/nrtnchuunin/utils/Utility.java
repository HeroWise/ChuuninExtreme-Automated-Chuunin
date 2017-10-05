package com.topobon.nrtnchuunin.utils;

import org.bukkit.ChatColor;



public class Utility {
	public static String decodeMessage(String message) {
        return message = ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&',message));
    }
	public static String sendInfo(String message) {
        return message = ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', "&8&l[&6Info&8&l]&r" +  message));
    }
}
