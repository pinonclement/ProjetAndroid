package com.project.projetandroid;

import java.util.ArrayList;
import java.util.Calendar;
import android.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.*;



public class SystemeJeu extends Activity {
	
	ArrayList<Joueur> nbrjoueur;
	Joueur joue;
	ReserveDes reserve;
	Calendar c=Calendar.getInstance();
	Calendar fin;
	private DBManager db = new DBManager(this);
	/*Construeurs de jeu*/
	public SystemeJeu(ArrayList<Joueur> nbrjoueur){
		this.nbrjoueur=nbrjoueur;

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
	/*On change de joueur*/
	public void passeTour(){
		int cpt=nbrjoueur.indexOf(joue); 
		if(cpt==nbrjoueur.size()-1) //si la position du joueur est � la fin, on recommence avec le premier
			joue=nbrjoueur.get(0);
		else
			joue=nbrjoueur.get(++cpt);} //joue est le joueur suivant dans la liste
	/*On r�initialise les valeurs de la r�serve, de joue de joueur, et son nombre de degat(il pourra repiocher � un nouveau tour*/
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
	//getters/setters
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
	
	//r�cup�re la date/heure de la fin de la partie
	protected void setFin(){
		fin=Calendar.getInstance();
	}
	
	//soustraction des secondes minutes pour savoir la dur�e de la partie
	protected int[] temps(){
		int[] temps=new int[2];
		int min_deb=c.get(Calendar.MINUTE);
		int min_fin=fin.get(Calendar.MINUTE);
		int sec_deb=c.get(Calendar.SECOND);
		int sec_fin=fin.get(Calendar.SECOND);
		System.out.println(sec_deb+" "+sec_fin);
		if(sec_fin-sec_deb>=0)
			temps[0]=sec_fin-sec_deb;
		else{
			temps[0]=sec_fin+60-sec_deb;
			min_fin--;
		}
		if(min_fin-min_deb>=0)
			temps[1]=min_fin-min_deb;
		else{
			temps[1]=min_fin+60-min_deb;
		}
		
		return temps;
	}
	
	protected String convertTemps(int[]tmp){
		  int tempo=tmp[1]+tmp[0];
		  return ""+tempo;
		 }

	//r�cup�ration de la date
	protected String date(){
		return ""+c.get(Calendar.DAY_OF_MONTH)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.YEAR);
	}
	
	
	
	
	
}
