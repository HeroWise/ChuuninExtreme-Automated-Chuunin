package com.topobon.nrtnchuunin.gameprocessing;

import org.bukkit.Bukkit;

import com.topobon.nrtnchuunin.ChuuninExam;
import com.topobon.nrtnchuunin.ChuuninExtreme;
import com.topobon.nrtnchuunin.utils.Utility;

public class GameManager {
	ChuuninExtreme instance;

	public GameManager(ChuuninExtreme instance) {
	
		checkPlayerState();
		setPlayersFighting();
	}

	public void checkPlayerState() {

		for (Participant p : ChuuninExam.getParticipantList()) {
			
			if (p.getNumberOfRoundsWon() == ChuuninExam.getNumberOfPointsToWin()) {
				p.getPlayer().sendMessage(" " + p.getNumberOfRoundsWon());
				Bukkit.broadcastMessage(
						Utility.decodeMessage("&6" + p.getPlayer().getName() + " &bhas won the Chuunin Exams!"));
				ChuuninExam.stopGame();
			}
		}

	}

	public void setPlayersFighting() {
		if (ChuuninExam.getFighting().size() <= 1 && ChuuninExam.getParticipantList().size() <= 1) {
			return;
		}
		System.out.println("test");
		//ChuuninExam.getFighting().clear();
		Participant p1 = ChuuninExam.getParticipantList().get(0);
		Participant p2 = ChuuninExam.getParticipantList().get(1);
		ChuuninExam.getFighting().add(p1);
		ChuuninExam.getFighting().add(p2);
		ChuuninExam.getParticipantList().remove(p1);
		ChuuninExam.getParticipantList().remove(p2);
		System.out.println(ChuuninExam.getFighting().get(0).getPlayer());
		
		broadcastPlayersFighting();
	}

	public void broadcastPlayersFighting() {
		Participant p1, p2;
		p1 = ChuuninExam.getFighting().get(0);
		p2 = ChuuninExam.getFighting().get(1);
		p1.getPlayer().teleport(ChuuninExam.getLocationA());
		p2.getPlayer().teleport(ChuuninExam.getLocationB());
		ChuuninExam.startTimer(3);
		Bukkit.broadcastMessage(Utility.decodeMessage(
				"&6" + p1.getPlayer().getName() + " &bis fighting &6" + p2.getPlayer().getName() + "&b!"));
	}

	public void crownPlayerAsWiner() {
		// DO BPERMS Stuff
	}

}
