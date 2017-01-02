package com.project.projetandroid;

class Jaune extends Des {
	private String couleur="Jaune";
	private String[] faces={"Pate","Pate","Casserole","Casserole","Fourchette","Fourchette"};
	private String faceDécouverte="";

	protected String getCouleur() {
		return couleur;
	}

	protected void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	protected String[] getFaces() {
		return faces;
	}

	protected void setFaces(String[] faces) {
		this.faces = faces;
	}

	protected String getFaceDécouverte() {
		return faceDécouverte;
	}

	protected void setFaceDécouverte(String faceDécouverte) {
		this.faceDécouverte = faceDécouverte;
	}

	private Jaune(String couleur, String[] faces) {
	}

}
