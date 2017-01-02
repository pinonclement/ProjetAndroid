
package com.project.projetandroid;
//import java.util.ArrayList;

public abstract class Des {

	private String couleur;
	private String[] faces;
	private String faceDÈcouverte="";
	
	protected abstract Des creation();
	


	public String[] getFaces() {
		return faces;
	}

	public void setFaces(String[] faces) {
		this.faces = faces;
	}

	public String getFaceDÈcouverte() {
		return faceDÈcouverte;
	}

	public void setFaceDÈcouverte(String faceDÈcouverte) {
		this.faceDÈcouverte = faceDÈcouverte;
	}

	public Des(String couleur,String[] faces){
		this.setCouleur(couleur);
		this.faces=faces;
	}



	public String getCouleur() {
		return couleur;
	}



	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	/*on pioche X d√©s
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
	} */

	// on lance les d√©s
/*
	public ArrayList ParcoursDes(ArrayList faces) {
		ArrayList listfaces = null;
		for (Object elt : faces) {
			int nombreAleatoire = 1 + (int) (Math.random() * ((13 - 1) + 1));
			if (elt.toString() == "vert") {
				if (nombreAleatoire <= 3)
					listfaces.add("pates");
				else if (nombreAleatoire > 3 && nombreAleatoire <= 5)
					listfaces.add("casserole");
				else
					listfaces.add("fourchette");
			}
			if (elt.toString() == "jaune") {
				if (nombreAleatoire <= 2)
					listfaces.add("pates");
				else if (nombreAleatoire > 2 && nombreAleatoire <= 4)
					listfaces.add("casserole");
				else
					listfaces.add("fourchette");

			}
			if (elt.toString() == "rouge") {
				if (nombreAleatoire <= 1)
					listfaces.add("pates");
				else if (nombreAleatoire > 1 && nombreAleatoire <= 3)
					listfaces.add("casserole");
				else
					listfaces.add("fourchette");

			}
		}

			return listfaces;
	}*/
}
