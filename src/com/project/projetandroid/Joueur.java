package com.project.projetandroid;

import java.util.ArrayList;

public class Joueur {

	private String pseudo;
	private int score_final;
	private int pate;
	private int casserole; // Inutile ?
	private int fourchette;
	private int nombredes;

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

	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		score_final = 0;
		pate = 0;
		casserole = 0;
		fourchette = 0;
	}

	// on pioche X dés
	public ArrayList pioche(int nombre) {
		ArrayList pioche = null;
		for (int i = 0; i <= nombre; i++) {
			int nombreAleatoire = 1 + (int) (Math.random() * ((13 - 1) + 1));
			if (nombreAleatoire <= 6)
				pioche.add("vert");
			else if (nombreAleatoire > 6 && nombreAleatoire <= 10)
				pioche.add("jaune");
			else
				pioche.add("rouge");
		}

		return pioche;
	}

	// on lance les dés

	public void ParcoursDes(ArrayList faces) {
		for (Object elt : faces) {
			int nombreAleatoire = 1 + (int) (Math.random() * ((13 - 1) + 1));
			if (elt.toString() == "vert") {
				if (nombreAleatoire <= 3)
					this.pate = this.pate + 1;
				else if (nombreAleatoire > 3 && nombreAleatoire <= 5)
					this.casserole = this.casserole + 1;
				else
					this.fourchette = this.fourchette + 1;
			}
			if (elt.toString() == "jaune") {
				if (nombreAleatoire <= 2)
					this.pate = this.pate + 1;
				else if (nombreAleatoire > 2 && nombreAleatoire <= 4)
					this.casserole = this.casserole + 1;
				else
					this.fourchette = this.fourchette + 1;
			}
			if (elt.toString() == "rouge") {
				if (nombreAleatoire <= 1)
					this.pate = this.pate + 1;
				else if (nombreAleatoire > 1 && nombreAleatoire <= 3)
					this.casserole = this.casserole + 1;
				else
					this.fourchette = this.fourchette + 1;
			}

		}

	}
	
	public void EtudeFace() {
		while(this.casserole < 3 | this.score_final< 13){
			
		}
	}
}