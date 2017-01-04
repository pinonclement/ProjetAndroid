package com.project.projetandroid;

import java.util.ArrayList;
import java.util.Calendar;

public class SystemeJeu {
	ArrayList<Joueur> nbrjoueur;
	Joueur joue;
	ReserveDes reserve;
	Calendar debut;
	Calendar fin;
	
	public SystemeJeu(ArrayList<Joueur> nbrjoueur){
		this.nbrjoueur=nbrjoueur;
		debut=Calendar.getInstance();
		ArrayList<Des> tmp=new ArrayList<Des>();
		tmp.add(new Rouge());
		tmp.add(new Rouge());
		tmp.add(new Rouge());
		tmp.add(new Rouge());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Vert());
		reserve=new ReserveDes(tmp);
		joue=nbrjoueur.get(0);
	}
	
	public void passeTour(){
		int cpt=nbrjoueur.indexOf(joue);
		if(cpt==nbrjoueur.size()-1)
			joue=nbrjoueur.get(0);
		else
			joue=nbrjoueur.get(++cpt);}
	
	protected void reinitialise(){
		ArrayList<Des> tmp=new ArrayList<Des>();
		tmp.add(new Vert());
		tmp.add(new Vert());
		tmp.add(new Rouge());
		tmp.add(new Rouge());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Jaune());
		tmp.add(new Rouge());
		tmp.add(new Rouge());
		reserve=new ReserveDes(tmp);
		joue.setFourchette(0);
		joue.setScore_tempo(0);
		joue.setJouer(false);
	}

	protected ArrayList<Joueur> getNbrjoueur() {
		return nbrjoueur;
	}

	protected void setNbrjoueur(ArrayList<Joueur> nbrjoueur) {
		this.nbrjoueur = nbrjoueur;
	}

	protected Joueur getJoue() {
		return joue;
	}

	protected void setJoue(Joueur joue) {
		this.joue = joue;
	}

	protected ReserveDes getReserve() {
		return reserve;
	}

	protected void setReserve(ReserveDes reserve) {
		this.reserve = reserve;
	}

	protected Calendar getDebut() {
		return debut;
	}

	protected void setDebut(Calendar debut) {
		this.debut = debut;
	}

	protected Calendar getFin() {
		return fin;
	}

	protected void setFin(Calendar fin) {
		this.fin = fin;
	}
	
	
	
	
}
