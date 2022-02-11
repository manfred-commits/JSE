package com.manfredipiraino.adapter.exercise;

class Adapter implements DataSource {
	private UserInfo myUserInfo;
	
	/*Getter*/
	public UserInfo getMyUserInfo() {
		return myUserInfo;
	}
	/*Setter*/
	public void setMyUserInfo(UserInfo myUserInfo) {
		this.myUserInfo = myUserInfo;
	}
	/*methods*/
	@Override
	public String getNomeComplete() {
		
		return myUserInfo.getNome()+" "+myUserInfo.getCognome();
	}


	
}