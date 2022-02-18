package com.manfredipiraino.my.exe.jdbc;

public class Tutor {

	private int id;
	private String nome;
	private String cognome;
	private String materia;
	
	Tutor(int id, String nome, String cognome, String materia){
		this.id=id;
		this.nome=nome;
		this.cognome=cognome;
		this.materia=materia;
	}
	/*Getter*/
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getMateria() {
		return materia;
	}
	/*Setter*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
}
