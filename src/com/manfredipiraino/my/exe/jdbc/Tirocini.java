package com.manfredipiraino.my.exe.jdbc;

public class Tirocini {
	private Tutor myTutor;
	private Azienda myAgency;
	private Tirocinante myTrainee;
	
	Tirocini(Tutor myTutor, Azienda myAgency, Tirocinante myTrainee) {
		this.myTutor = myTutor;
		this.myAgency = myAgency;
		this.myTrainee = myTrainee;
	}

	/*Getter*/
	public Tutor getMyTutor() {
		return myTutor;
	}
	public Azienda getMyAgency() {
		return myAgency;
	}
	public Tirocinante getMyTrainee() {
		return myTrainee;
	}
	/*Setter*/
	public void setMyTutor(Tutor myTutor) {
		this.myTutor = myTutor;
	}
	public void setMyAgency(Azienda myAgency) {
		this.myAgency = myAgency;
	}
	public void setMyTrainee(Tirocinante myTrainee) {
		this.myTrainee = myTrainee;
	}
	
}
