package com.project.projetandroid;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JeuActivity extends Activity implements OnClickListener  {
	
	ArrayList<Joueur> al = new ArrayList<Joueur>();
	SystemeJeu jeu;
    private static final int DIALOG_ALERT = 10;

	public void onCreate(Bundle bn) {

		setContentView(R.layout.jeulayout);
		super.onCreate(bn);
		String user1 = getIntent().getStringExtra("user1");
		String user2 = getIntent().getStringExtra("user2");
		String user3 = getIntent().getStringExtra("user3");
		String user4 = getIntent().getStringExtra("user4");
		al=DefinirJoueur(user1,user2,user3,user4,al);
		jeu=new SystemeJeu(al);
		showDialog(DIALOG_ALERT);
		Button b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);
		Button b2=(Button)findViewById(R.id.button3);
		b2.setOnClickListener(this);
		Button b3=(Button)findViewById(R.id.button2);
		b3.setOnClickListener(this);
		TextView joujou=(TextView)findViewById(R.id.joueur);
		joujou.setText(jeu.getJoue().getPseudo());
		TextView scoring=(TextView)findViewById(R.id.score);
		scoring.setText(""+jeu.getJoue().getScore_final());
	}

	public ArrayList<Joueur> DefinirJoueur(String a, String b, String c, String d, ArrayList <Joueur> al) {
		al.add(new Joueur (a));
        al.add(new Joueur(b));
			if (c.length()!=0 )
				al.add(new Joueur(c));
            if(d.length()!=0)
                al.add(new Joueur(d));
			
		return al;
	}




    /** Called when the activity is first created. */



    public void onClick(View view) {
    	TextView desun=(TextView)findViewById(R.id.textView1);
		TextView desdeux=(TextView)findViewById(R.id.textView2);
		TextView detroit=(TextView)findViewById(R.id.textView3);
		TextView joujou=(TextView)findViewById(R.id.joueur);

		ReserveDes res=jeu.getReserve();
    	switch(view.getId()){
    		case DIALOG_ALERT :
    			showDialog(DIALOG_ALERT);
    			break;
    		case R.id.button1 :
    			res.pioche(jeu.getJoue());
    			Des[]tmp=(jeu.getJoue()).getMain();
    			desun.setText(""+tmp[0].getCouleur()+" "+tmp[0].getFaceRetournee());
    			desdeux.setText(""+tmp[1].getCouleur()+" "+tmp[1].getFaceRetournee());
    			detroit.setText(""+tmp[2].getCouleur()+" "+tmp[2].getFaceRetournee());
    			break;
    		case R.id.button3 :
    			if(jeu.getJoue().aCasserole())
    				jeu.getJoue().analyseTempo();
    				res.relance(jeu.getJoue());
    				Des[]tmp1=(jeu.getJoue()).getMain();
    				desun.setText(""+tmp1[0].getCouleur()+" "+tmp1[0].getFaceRetournee());
    				desdeux.setText(""+tmp1[1].getCouleur()+" "+tmp1[1].getFaceRetournee());
    				detroit.setText(""+tmp1[2].getCouleur()+" "+tmp1[2].getFaceRetournee());
    			break;
    		case R.id.button2 :
    			if(jeu.getJoue().getFourchette()>=3)
    				jeu.getJoue().perdre();
    			jeu.getJoue().gain();
    			if(jeu.getJoue().gagne())
    				finish();
    			else{
    				jeu.getJoue().setJouer(true);
    				desun.setText("vide");
    				desdeux.setText("vide");
    				detroit.setText("vide");
    				jeu.passeTour();
    				jeu.reinitialise();
    				joujou.setText(jeu.getJoue().getPseudo());
    			}
    			
    			break;
    	}
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_ALERT:
                // Create out AlterDialog
                Builder builder = new AlertDialog.Builder(this);
                builder.setMessage((jeu.getJoue().getPseudo())+"  ton tour !");
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