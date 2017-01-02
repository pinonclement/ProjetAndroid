package com.project.projetandroid;

class Rouge extends Des {
	private String couleur="Rouge";
	private String[] faces={"Pate","Casserole","Casserole","Fourchette","Fourchette","Fourchette"};
	
	
	public Rouge(String couleur, String[] faces) {
		super(couleur, faces);
	}
	
	protected Des creation(){
		return new Rouge(couleur,faces);
	}

}
