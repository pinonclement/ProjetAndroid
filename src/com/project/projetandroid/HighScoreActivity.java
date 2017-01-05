package com.project.projetandroid;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class HighScoreActivity extends Activity {
	private DBManager db = new DBManager(this);
	
	ArrayList partie = (ArrayList) db.getAllPartie();

	
	
	//http://www.tutomobile.fr/personnaliser-une-listview-tutoriel-android-n%C2%B07/04/07/2010/
	
	ListView maListViewPerso;
	
		    public void onCreate(Bundle savedInstanceState) {
		    	
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.mainhighscore);
		        db.open();
		 
		        //Récupération de la listview créée dans le fichier main.xml
		        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
		 
		        //Création de la ArrayList qui nous permettra de remplire la listView
		        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		 
		        //On déclare la HashMap qui contiendra les informations pour une partie
		        HashMap<String, String> map;
	
		        //ajout des elements dans la map
		 
		        map = new HashMap<String, String>();
		        map.put("gagnant", ((Partie) partie.get(0)).getJoueur());
		        map.put("points", ((Partie) partie.get(0)).getPoints());
		        map.put("duree", ((Partie) partie.get(0)).getTemps());
		        map.put("date",((Partie) partie.get(0)).getDate()) ;
		     
		        listItem.add(map);
		
		 
		        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
		        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.highscorelayout,
		               new String[] {"gagnant", "points", "duree", "date"}, new int[] {R.id.gagnant, R.id.points, R.id.duree,R.id.date });
		 
		        //On attribut à notre listView l'adapter que l'on vient de créer
		        maListViewPerso.setAdapter(mSchedule);
		 

		 
		    }
		}
