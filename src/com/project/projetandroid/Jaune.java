package com.project.projetandroid;

class Jaune extends Des {
	private String couleur="Jaune";
	private String[] faces={"Pate","Pate","Casserole","Casserole","Fourchette","Fourchette"};
	private String faceD�couverte="";

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

	protected String getFaceD�couverte() {
		return faceD�couverte;
	}

	protected void setFaceD�couverte(String faceD�couverte) {
		this.faceD�couverte = faceD�couverte;
	}

	private Jaune(String couleur, String[] faces) {
	}

}
