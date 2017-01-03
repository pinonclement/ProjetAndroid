package com.project.projetandroid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class SystemeJeu {
	ArrayList<Joueur> nbrjoueur;
	ReserveDes init;
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
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Vert());
		tmp.add(new Vert());
		reserve=new ReserveDes(tmp);
		init=reserve;
		joue=nbrjoueur.get(0);
	}
	
	public void passeTour(){
		if(nbrjoueur.indexOf(joue)==nbrjoueur.size()-1)
			joue=nbrjoueur.get(0);
		else{
		Iterator<Joueur> iter=nbrjoueur.iterator();
		while(iter.hasNext()){
			if(iter.next()!=joue&&iter.next()!=null){
				joue=iter.next();
			}
		}
		}
		
	}
	
	protected void reinitialise(){
		reserve=init;
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
