package com.project.projetandroid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Accueil extends Activity implements OnClickListener {
	
	private Button newsgamebutton; // Bouton nouvelle partie
	private Button highscorebutton; // Bouton high score

	public void onCreate(Bundle bn){
		setContentView(R.layout.accueillayout);
		super.onCreate(bn);
	newsgamebutton = (Button) findViewById(R.id.newgamebutton);
	highscorebutton = (Button) findViewById(R.id.highscorebutton);
	newsgamebutton.setOnClickListener(this);
	highscorebutton.setOnClickListener(this);
	
	
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		// gestion bouton nouvelle partie
		case R.id.newgamebutton:
			Intent intent2 = new Intent(this, Surnom.class);
			startActivity(intent2);
			break;		
			// gestion bouton high score
		case R.id.highscorebutton:
			Intent intent = new Intent(this, HighScoreActivity.class);
			startActivity(intent);
			break;	
	} 
		finish();

}
}
