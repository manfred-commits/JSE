package com.manfredipiraino.adapter.exercise;

public class Client {

	public static void main(String[] args) {
		
		UserData myUserData=new UserData("Mario Rossi");
		UserInfo myUserInfo=new UserInfo("Giovanna","Verdi");
		
		System.out.println("UserData with get nomeCompleto: "+myUserData.getNomeComplete());
		System.out.println("UserInfo with get nome/cognome: "+myUserInfo.getNome()+" "+myUserInfo.getCognome());
	
		Adapter myAdapter=new Adapter();
		myAdapter.setMyUserInfo(myUserInfo);
		System.out.println("Adapter for UserInfo with get nomeCompleto: "+myAdapter.getNomeComplete());
		
		myAdapter.setMyUserData(myUserData);
		System.out.println("Adapter for UserData with get nome/cognome: "+myAdapter.getNome()+" "+myAdapter.getCognome());
	}

}
