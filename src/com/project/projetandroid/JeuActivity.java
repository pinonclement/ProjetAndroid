package com.project.projetandroid;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class JeuActivity extends Activity {
	
	//private String user1 = getIntent().getStringExtra("user1");
	//String user2 = getIntent().getStringExtra("user2");
	//String user3 = getIntent().getStringExtra("user3");
	//String user4 = getIntent().getStringExtra("user4");
	ArrayList al = new ArrayList();
    private static final int DIALOG_ALERT = 10;

	public void onCreate(Bundle bn) {

		setContentView(R.layout.jeulayout);
		super.onCreate(bn);
		
		String user1 = getIntent().getStringExtra("user1");
		String user2 = getIntent().getStringExtra("user2");
		String user3 = getIntent().getStringExtra("user3");
		String user4 = getIntent().getStringExtra("user4");
		
		al=DefinirJoueur(user1,user2,user3,user4,al);
		showDialog(DIALOG_ALERT);
	}

	public ArrayList DefinirJoueur(String a, String b, String c, String d, ArrayList al) {

		if (c.length()==0 && d.length()==0) {
			Joueur joueur1 = new Joueur(a);
			Joueur joueur2 = new Joueur(b);
			al.add(joueur1);
			al.add(joueur2);
		}
		else{
			if (d.length()==0 ){
				Joueur joueur1 = new Joueur(a);
				Joueur joueur2 = new Joueur(b);
				Joueur joueur3 = new Joueur(c);
				al.add(joueur1);
				al.add(joueur2);
				al.add(joueur3);
			}
            else{
                Joueur joueur1 = new Joueur(a);
                Joueur joueur2 = new Joueur(b);
                Joueur joueur3 = new Joueur(c);
                Joueur joueur4 = new Joueur(d);
                al.add(joueur1);
                al.add(joueur2);
                al.add(joueur3);
                al.add(joueur4);

            }
		}
			
		return al;
	}




    /** Called when the activity is first created. */



    public void onClick(View view) {
        showDialog(DIALOG_ALERT);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_ALERT:
                // Create out AlterDialog
                Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(((Joueur) al.get(0)).getPseudo()+"à ton tour !");
                builder.setCancelable(true);
                builder.setPositiveButton("Ok", new OkOnClickListener());
               // builder.setNegativeButton("OK", new CancelOnClickListener());
                AlertDialog dialog = builder.create();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    private final class CancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "Activity will continue",
                    Toast.LENGTH_LONG).show();
        }
    }

    private final class OkOnClickListener implements
            DialogInterface.OnClickListener {
    	 public void onClick(DialogInterface dialog, int which) {
             Toast.makeText(getApplicationContext(), "C'est parti !!!",
                     Toast.LENGTH_LONG).show();
    }
    }
}