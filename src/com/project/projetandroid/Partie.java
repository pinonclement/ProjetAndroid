package com.project.projetandroid;

public class Partie {
	private long id;
	private String joueur;
	private String points;
	private String temps;
	private String date;
	
	public Partie(long id, String joueur, String points,String temps, String date ){
		super();
		this.id=id;
		this.joueur=joueur;
		this.points=points;
		this.temps=temps;
		this.date=date;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJoueur() {
		return joueur;
	}

	public void setJoueur(String joueur) {
		this.joueur = joueur;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
