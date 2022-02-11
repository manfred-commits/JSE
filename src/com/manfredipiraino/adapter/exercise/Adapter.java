package com.manfredipiraino.adapter.exercise;

class Adapter implements DataSource,DataSource2 {
	private UserInfo myUserInfo;
	private UserData myUserData;
	
	/*Getter*/
	public UserInfo getMyUserInfo() {
		return myUserInfo;
	}
	public UserData getMyUserData() {
		return myUserData;
	}
	/*Setter*/
	public void setMyUserInfo(UserInfo myUserInfo) {
		this.myUserInfo = myUserInfo;
	}
	public void setMyUserData(UserData myUserData) {
		this.myUserData = myUserData;
	}
	/*methods*/
	public String getNome() {
		String[] tmp=myUserData.getNomeComplete().split(" ");
		return tmp[0];
	}
	public String getCognome() {
		String[] tmp=myUserData.getNomeComplete().split(" ");
		return tmp[1];
	}
	@Override
	public String getNomeComplete() {
		
		return myUserInfo.getNome()+" "+myUserInfo.getCognome();
	}


	
}