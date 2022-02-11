package com.manfredipiraino.adapter.exercise;

public class UserInfo {
	private String nome;
	private String cognome;
	
	UserInfo(String nome, String cognome){
		this.nome=nome;
		this.cognome=cognome;
	}
	/*Getter*/
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	/*Setter*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}
