package com.manfredipiraino.my.exe.jdbc;

public class Azienda {
	
	private int id;
	private String nome;
	private String luogo;
	private String settore;
	private String tipologia;
	
	Azienda(int id, String nome, String luogo, String settore, String tipologia) {
		super();
		this.id = id;
		this.nome = nome;
		this.luogo = luogo;
		this.settore = settore;
		this.tipologia = tipologia;
	}
	/*Getter*/
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getLuogo() {
		return luogo;
	}
	public String getSettore() {
		return settore;
	}
	public String getTipologia() {
		return tipologia;
	}
	/*Setter*/
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public void setSettore(String settore) {
		this.settore = settore;
	}

	

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}
