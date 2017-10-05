package com.topobon.nrtnchuunin.gameprocessing;

import com.topobon.nrtnchuunin.ChuuninExam;
import com.topobon.nrtnchuunin.ChuuninExtreme;

public class GameManager {
	ChuuninExtreme instance;
	public GameManager(ChuuninExtreme instance) {
		
	}
	
	public void setPlayersFighting(){
		
		for(int i = 0; i<=1;i++){
			ChuuninExam.getFighting().add(ChuuninExam.getParticipantList().get(i));
			ChuuninExam.getParticipantList().remove(ChuuninExam.getParticipantList().get(i));
			
		}
	}
	public void broadcastPlayersFighting(Participant p1, Participant p2){
		
	}
	public void crownPlayerAsWiner(){
		
	}
	
}
