package com.project.projetandroid;

class Rouge extends Des {
	private String couleur="Rouge";
	private String[] faces={"Pate","Casserole","Casserole","Fourchette","Fourchette","Fourchette"};
	private String faceD�couverte="";
	
	
	private Rouge() {
	}


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
	
}
