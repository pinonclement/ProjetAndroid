package com.project.projetandroid;

 class Vert extends Des {
	private String couleur="Vert";
	private String[] faces={"Pate","Pate","Pate","Casserole","Casserole","Fourchette"};
	private String faceRetournee="";
	
	
	protected Vert() {
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


	protected String getFaceRetournee() {
		return faceRetournee;
	}


	protected void setFaceRetournee(String faceRetournee) {
		this.faceRetournee = faceRetournee;
	}
	
	//choix al�atoire de la face simulant un lanc� de d�
	@Override
	protected void faceTire() {
		int faceChoisie=(int)(Math.random()*faces.length);
		this.faceRetournee=faces[faceChoisie];	
	}
}
