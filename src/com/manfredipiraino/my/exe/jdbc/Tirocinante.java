package com.manfredipiraino.my.exe.jdbc;

public class Tirocinante {

	private int id;
	private String matricola;
	private String nome;
	private String cognome;
	private String classe;
	private int idazienda;
	private int idtutor;
	
	Tirocinante(int id, String matricola, String nome, String cognome, String classe, int idazienda,
			int idtutor) {
		this.id = id;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.classe = classe;
		this.idazienda = idazienda;
		this.idtutor = idtutor;
	}
	
	/*getter*/
	public int getId() {
		return id;
	}
	public String getMatricola() {
		return matricola;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getClasse() {
		return classe;
	}
	public int getIdazienda() {
		return idazienda;
	}
	public int getIdtutor() {
		return idtutor;
	}
	/*setter*/
	public void setId(int id) {
		this.id = id;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public void setIdazienda(int idazienda) {
		this.idazienda = idazienda;
	}
	public void setIdtutor(int idtutor) {
		this.idtutor = idtutor;
	}
}
