package com.topobon.nrtnchuunin.utils;

import org.bukkit.ChatColor;

import com.topobon.nrtnchuunin.ChuuninExtreme;



public class Utility {
	public static String decodeMessage(String message) {
        return message = ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&',ChuuninExtreme.getChuuninLogo().getLogo()+ message));
    }
	public static String sendInfo(String message) {
        return message = ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', ChuuninExtreme.getInfoLogo().getLogo() +  message));
    }
}
