package com.project.projetandroid;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

public class JeuActivity extends Activity {

	public void onCreate(Bundle bn) {

		setContentView(R.layout.jeulayout);
		super.onCreate(bn);
	/*	for (int i = 0; i < DefinirJoueur().size(); i++) {
			new Joueur(DefinirJoueur().get(i));
		} */
	}

	public ArrayList<String> DefinirJoueur() {
	
		ArrayList<String> listjoueur = null; // Liste de joueurs
		if (getIntent().getStringExtra("user1").length() > 0)
			listjoueur.add(getIntent().getStringExtra("user1"));
		if (getIntent().getStringExtra("user2").length() > 0)
			listjoueur.add(getIntent().getStringExtra("user2"));
		if (getIntent().getStringExtra("user3").length() > 0)
			listjoueur.add(getIntent().getStringExtra("user3"));
		if (getIntent().getStringExtra("user4").length() > 0)
			listjoueur.add(getIntent().getStringExtra("user4"));
		return listjoueur;
	}
}