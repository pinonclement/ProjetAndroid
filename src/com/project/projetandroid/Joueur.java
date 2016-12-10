package com.project.projetandroid;

public class Joueur {
	
	private String pseudo;
	private int score_final;
	private int pate;
	private int casserole; // Inutile ?
	private int fourchette;

	

	public String getPseudo() {
		return pseudo;
	}



	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	public int getScore_final() {
		return score_final;
	}



	public void setScore_final(int score_final) {
		this.score_final = score_final;
	}



	public int getPate() {
		return pate;
	}



	public void setPate(int pate) {
		this.pate = pate;
	}



	public int getCasserole() {
		return casserole;
	}



	public void setCasserole(int casserole) {
		this.casserole = casserole;
	}



	public int getFourchette() {
		return fourchette;
	}



	public void setFourchette(int fourchette) {
		this.fourchette = fourchette;
	}



	public Joueur (String pseudo){
		this.pseudo=pseudo;
		score_final=0;
		pate=0;
		casserole=0;
		fourchette=0;
	}
}
