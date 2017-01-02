package com.project.projetandroid;

class Rouge extends Des {
	private String couleur="Rouge";
	private String[] faces={"Pate","Casserole","Casserole","Fourchette","Fourchette","Fourchette"};
	private String faceRetournee="";
	
	
	protected Rouge() {
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


	@Override
	protected void faceTire() {
		int faceChoisie=((int)Math.random()*faces.length);
		this.faceRetournee=faces[faceChoisie];	
	}
	
}
