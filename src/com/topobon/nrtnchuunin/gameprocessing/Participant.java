package com.topobon.nrtnchuunin.gameprocessing;

import org.bukkit.entity.Player;



public class Participant {
	private Player player;
	private int numberOfRoundsWon;

	public Participant(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;

	}

	public void setNumberOfRoundsWon(int wonRounds) {
		this.numberOfRoundsWon = wonRounds;
	}

	public Integer getNumberOfRoundsWon() {
		return numberOfRoundsWon;
	}

//	public Permission[] getInfo(Player player) {
//		return ApiLayer.getPermissions(player.getWorld().getName(),CalculableType.USER, player.getName());
//	}
}
