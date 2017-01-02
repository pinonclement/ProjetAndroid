package com.project.projetandroid;

public class Jaune extends Des {
	private String couleur="Jaune";
	private String[] faces={"Pate","Pate","Casserole","Casserole","Fourchette","Fourchette"};
	
	
	
	public Jaune(String couleur, String[] faces) {
		super(couleur, faces);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Des creation() {
		
		return new Jaune(couleur,faces);
		}
	

}
