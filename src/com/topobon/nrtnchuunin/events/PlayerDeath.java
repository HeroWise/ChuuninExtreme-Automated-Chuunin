package com.topobon.nrtnchuunin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.topobon.nrtnchuunin.ChuuninExam;
import com.topobon.nrtnchuunin.ChuuninExtreme;
import com.topobon.nrtnchuunin.gameprocessing.GameManager;
import com.topobon.nrtnchuunin.utils.Utility;

public class PlayerDeath implements Listener {
	ChuuninExtreme instance;

	public PlayerDeath(ChuuninExtreme instance) {
		this.instance = instance;
	}

	@EventHandler
	public void playerDeath(PlayerDeathEvent e) {
		Player killedPlayer = e.getEntity().getPlayer();
		Player killer;

		if (ChuuninExam.isChuuninOn()) {

			if (ChuuninExam.getFighting().get(0).equals(ChuuninExam.getParticipantObject(killedPlayer))) {
				ChuuninExam.getFighting().get(1)
						.setNumberOfRoundsWon(ChuuninExam.getFighting().get(1).getNumberOfRoundsWon() + 1);
				ChuuninExam.getParticipantList().add(ChuuninExam.getFighting().get(1));
			
				killer = ChuuninExam.getFighting().get(1).getPlayer();
				Bukkit.broadcastMessage(Utility.decodeMessage(
						"&6" + killer.getName() + " &bhas claimed victory against &6" + killedPlayer.getName() + " &b!"));
				killer.setHealth(killer.getHealth());
				killer.teleport(ChuuninExam.getSpawnLocation());
				new GameManager(instance);
				killer.sendMessage(" Personal Number of Rounds won: "+ChuuninExam.getFighting().get(1).getNumberOfRoundsWon()+" ");
				ChuuninExam.getFighting().clear();
				System.out.println("was here");
				
				return;
			}
			if (ChuuninExam.getFighting().get(1).equals(ChuuninExam.getParticipantObject(killedPlayer))) {
				
				ChuuninExam.getFighting().get(0)
						.setNumberOfRoundsWon(ChuuninExam.getFighting().get(0).getNumberOfRoundsWon() + 1);
				ChuuninExam.getParticipantList().add(ChuuninExam.getFighting().get(0));
				ChuuninExam.getFighting().remove(1);

				killer = ChuuninExam.getFighting().get(0).getPlayer();
				Bukkit.broadcastMessage(Utility.decodeMessage(
						"&6" + killer.getName() + " &bhas claimed victory against &6" + killedPlayer.getName() + " &b!"));
				killer.setHealth(killer.getHealth());
				
				killer.teleport(ChuuninExam.getSpawnLocation());
				killer.sendMessage(" "+ChuuninExam.getFighting().get(1).getNumberOfRoundsWon()+" ");
				new GameManager(instance);
				ChuuninExam.getFighting().clear();
				
				return;
			}
			
			

		}
	}
}
