package com.manfredipiraino.adapter.exercise;

public class UserData implements DataSource{
	private String nomeCompleto;
	
	UserData(String nomeCompleto){
		this.nomeCompleto=nomeCompleto;
	}
	/*Getter*/
	
	/*Setter*/
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	/*Methods*/
	@Override
	public String getNomeComplete() {
		return nomeCompleto;
	}

}
