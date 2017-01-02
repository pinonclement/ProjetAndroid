package com.project.projetandroid;

import java.util.ArrayList;
import java.util.Calendar;

public class SystemeJeu {
	ArrayList<Joueur> nbrjoueur;
	ReserveDes reserve;
	Calendar debut;
	Calendar fin;
	
	public SystemeJeu(ArrayList<Joueur> nbrjoueur){
		this.nbrjoueur=nbrjoueur;
		debut=Calendar.getInstance();
		ArrayList<Des> tmp=new ArrayList<Des>();
		tmp.add(new Rouge());
		tmp.add(new Rouge());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Jaune());
		tmp.add(new Vert());
		tmp.add(new Vert());
		tmp.add(new Vert());
		reserve=new ReserveDes(tmp);
	}
	
}
