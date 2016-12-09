package com.project.projetandroid;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class Surnom extends Activity{
	
	

		public void onCreate(Bundle bn){
			getIntent();
			super.onCreate(bn);
			setContentView(R.layout.surnomlayout);
			Spinner spinner = (Spinner) findViewById(R.id.spinnernbjoueur);
			List<String> list = new ArrayList<String>();
			list.add("2");
			list.add("3");
			list.add("4");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner.setAdapter(dataAdapter);
		  }
		
	}
/*
echo "# ProjetAndroid" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/pinonclement/ProjetAndroid.git
git push -u origin master
*/