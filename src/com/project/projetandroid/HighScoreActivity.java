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

	
	
	//http://www.tutomobile.fr/personnaliser-une-listview-tutoriel-android-n%C2%B07/04/07/2010/
	
	ListView maListViewPerso;
	
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.mainhighscore);
		 
		        //Récupération de la listview créée dans le fichier main.xml
		        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
		 
		        //Création de la ArrayList qui nous permettra de remplire la listView
		        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		 
		        //On déclare la HashMap qui contiendra les informations pour un item
		        HashMap<String, String> map;
		 
		        //Création d'une HashMap pour insérer les informations du premier item de notre listView
		        map = new HashMap<String, String>();
		        //on insère un élément titre que l'on récupérera dans le textView titre créé dans le fichier affichageitem.xml
		        map.put("titre", "Word");
		        //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier affichageitem.xml
		        map.put("description", "Editeur de texte");
		        //enfin on ajoute cette hashMap dans la arrayList
		        listItem.add(map);
		 
		        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
		 
		        map = new HashMap<String, String>();
		        map.put("titre", "Excel");
		        map.put("description", "Tableur");
		     
		        listItem.add(map);
		 
		        map = new HashMap<String, String>();
		        map.put("titre", "Power Point");
		        map.put("description", "Logiciel de présentation");
		        
		        listItem.add(map);
		 
		        map = new HashMap<String, String>();
		        map.put("titre", "Outlook");
		        map.put("description", "Client de courrier électronique");
		  
		        listItem.add(map);
		 
		        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
		        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.highscorelayout,
		               new String[] {"gagnant", "points", "duree", "date"}, new int[] {R.id.gagnant, R.id.points, R.id.duree,R.id.date });
		 
		        //On attribut à notre listView l'adapter que l'on vient de créer
		        maListViewPerso.setAdapter(mSchedule);
		 

		 
		    }
		}
