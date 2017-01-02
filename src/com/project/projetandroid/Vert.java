package com.project.projetandroid;

public class Vert extends Des {
	private String couleur="Jaune";
	private String[] faces={"Pate","Pate","Pate","Casserole","Casserole","Fourchette"};
	
	
	public Vert(String couleur, String[] faces) {
		super(couleur, faces);
	}

	@Override
	protected Des creation() {
		// TODO Auto-generated method stub
		return new Jaune(couleur,faces);
	}

}
