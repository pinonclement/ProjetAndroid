package com.project.projetandroid;

class Jaune extends Des {
	private String couleur="Jaune";
	private String[] faces={"Pate","Pate","Casserole","Casserole","Fourchette","Fourchette"};
	private String faceRetournee="";

	protected String getFaceRetournee() {
		return faceRetournee;
	}

	protected void setFaceRetournee(String faceRetournee) {
		this.faceRetournee = faceRetournee;
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


	private Jaune(String couleur, String[] faces) {
	}

	@Override
	protected void faceTire() {
		int faceChoisie=((int)Math.random()*faces.length);
		this.faceRetournee=faces[faceChoisie];	
	}

}
