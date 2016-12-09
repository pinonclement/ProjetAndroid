package com.project.projetandroid;

public class Joueur {
	
	private String pseudo;
	private int score_final;
	private int pate;
	private int casserole; // Inutile ?
	private int fourchette;

	

	public Joueur (String pseudo){
		this.pseudo=pseudo;
		score_final=0;
		pate=0;
		casserole=0;
		fourchette=0;
	}
}
