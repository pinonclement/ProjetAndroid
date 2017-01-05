package com.project.projetandroid;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JeuActivity extends Activity implements OnClickListener  {
	private DBManager db = new DBManager(this);
	
	ArrayList<Joueur> al = new ArrayList<Joueur>();
	SystemeJeu jeu;
	String date;
    private static final int DIALOG_ALERT = 10;
	private static final int DIALOG_DEGAT = 11;
	private static final int DIALOG_VICT = 12;
	private static final int DIALOG_VIDE = 13;
	

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
			
		return al; // Renvoi liste  des joueurs saisies
	}




    

/*Gestion des �v�nements chaque id de bouton r�cup�rer par le view.getId()
 * chaque id aura une action particuli�re  */

    public void onClick(View view) {
    	TextView desun=(TextView)findViewById(R.id.textView1); //r�cup�ration de tout les textview
		TextView desdeux=(TextView)findViewById(R.id.textView2);
		TextView detroit=(TextView)findViewById(R.id.textView3);
		TextView joujou=(TextView)findViewById(R.id.joueur);
		TextView scoretempo=(TextView)findViewById(R.id.tempo);
		TextView pv=(TextView)findViewById(R.id.degat);
		TextView scoring=(TextView)findViewById(R.id.score);
		TextView des5=(TextView)findViewById(R.id.des5);
		ReserveDes res=jeu.getReserve(); //r�cup�ration de la r�serve de d�s dans systemJeu via un get
    	switch(view.getId()){
    		case R.id.button1 : //si bouton cliqu� (ici bouton lancer)
    			if(!jeu.getJoue().isJouer()){  //si le joueur n'a pas encore jou�
    			res.pioche(jeu.getJoue()); //on appelle la m�thode qui pioche dans la r�serve
    			Des[]tmp=(jeu.getJoue()).getMain(); //r�cup�ration de la main du joueur
    			desun.setText(""+tmp[0].getCouleur()+" "+tmp[0].getFaceRetournee()); //affectation variable au champ correspond et en r�cup�rant la couleur du d�s et sa face via des getters
    			desdeux.setText(""+tmp[1].getCouleur()+" "+tmp[1].getFaceRetournee());// "" ""
    			detroit.setText(""+tmp[2].getCouleur()+" "+tmp[2].getFaceRetournee()); // "" ""
    			scoring.setText(""+jeu.getJoue().getScore_final()); // "" ""
    			jeu.getJoue().analyseTempo(); // analyse de la main du joueur (voir m�thode dans joueur.java)
    			pv.setText(""+jeu.getJoue().getFourchette()); //affectation variable au champ correspondant en r�up�rant la valeur du joueur via des getters
    			scoretempo.setText(""+jeu.getJoue().getScore_tempo());// "" "" 
    			des5.setText(""+jeu.getReserve().getReserve().size());}// "" ""
    			break; //on arr�te la boucle
    		case R.id.button3 : //si bouton relance cliqu�
    			if(jeu.getJoue().aCasserole()&&jeu.getJoue().getFourchette()<3){ //on v�rifie si le joueur n'a pas 3 fourchettes et s'il poss�de des d�s face casserole
    				res.relance(jeu.getJoue());// on appelle la m�thode relance de r�serveDes avec comme param�tre le joueur qui joue
    				Des[]tmp1=(jeu.getJoue()).getMain(); //r�cup�ration de la nouvelle main
    				desun.setText(""+tmp1[0].getCouleur()+" "+tmp1[0].getFaceRetournee()); //affectation variable / affichage r�sultat
    				desdeux.setText(""+tmp1[1].getCouleur()+" "+tmp1[1].getFaceRetournee());
    				detroit.setText(""+tmp1[2].getCouleur()+" "+tmp1[2].getFaceRetournee());
    				jeu.getJoue().analyseTempo(); // mise � jour de l'analyse de la main
    				scoretempo.setText(""+jeu.getJoue().getScore_tempo()); //on regarde la valeur de la main
    				pv.setText(""+jeu.getJoue().getFourchette()); //affiche r�sultat
    				des5.setText(""+jeu.getReserve().getReserve().size());} // ""
    		
    			break;
    		case R.id.button2 : //si bouton fin de tour
    			if(jeu.getJoue().getFourchette()>=3) //si le joueur a subit au moins 3 degats
    				jeu.getJoue().perdre(); //le score tempo est �gale � 0
    			jeu.getJoue().gain(); //on rajoute au score total, le score tempo
    			
    			if(jeu.getJoue().gagne()){ //si le joueur gagne (13 points au plus)
    				showDialog(DIALOG_VICT); //appelle de la fenetre de dialogue victoire
    				}
    			else{
    				desun.setText("vide"); //r�initialisation de tout les param�tres
    				desdeux.setText("vide");
    				detroit.setText("vide");
    				jeu.reinitialise(); 
    				jeu.passeTour(); // changement joueur
    				scoretempo.setText(""+jeu.getJoue().getScore_tempo()); //on affiche les valeurs du joueurs
    				pv.setText(""+jeu.getJoue().getFourchette());
    				joujou.setText(jeu.getJoue().getPseudo());
    				scoring.setText(""+jeu.getJoue().getScore_final());
    				des5.setText(""+jeu.getReserve().getReserve().size());
    				showDialog(DIALOG_ALERT); //affiche dialogue pour avertir le joueur
    			}
    			
    			break;
    	}
		if(jeu.getJoue().getFourchette()>=3) //si le joueur a plus de 3 points degats, appelle une fenetre qui l'informe
			showDialog(DIALOG_DEGAT);
		if(jeu.getReserve().getReserve().size()==0) // informe le joueur, que la r�serve est vide
			showDialog(DIALOG_VIDE);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
    	String message="";
        switch (id) {
            case DIALOG_ALERT:  //affection message
                // Create out AlterDialog
            	message=jeu.getJoue().getPseudo()+" A ton tour !";
                break;
            case DIALOG_DEGAT: //affection message
            	message="Vous avez pris 3 dégats, vous ne pouvez que passer votre tour";
            	break;
            case DIALOG_VICT : //si on appelle la fenetre de victoire
            	db.open();
            	message="Vous avez gagné"; 
            	jeu.setFin();
            	int[] temps=jeu.temps(); //r�cup�ration du temps de la partie
            	String duree=jeu.convertTemps(temps);
            	Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(""+jeu.getJoue().getPseudo()+" a gagné !"+"\n Durée de la partie : "+temps[1]+" minutes et "+temps[0]+" secondes \n Score : "+jeu.getJoue().getScore_final()); //affiche le score, le joueur victorieux, le temps de la partie
                builder.setCancelable(true);
                builder.setPositiveButton("Retour Menu", new ReturnOnclick()); //cr�ation bouton retour Menu
                builder.setNegativeButton("Recommencer", new RecommenceOnclick()); //cr�ation bouton Recommencer
                AlertDialog dialog = builder.create();
                dialog.show();
                date=jeu.date();
                db.createPartie(jeu.getJoue().getPseudo(), jeu.getJoue().getScore_final(),duree, date);
                return super.onCreateDialog(id);
            case DIALOG_VIDE : //si appelle � ce dialogue le message vaut "Plus de d�s"
            	message="Plus de dés";
            	break;
        }
        Builder builder = new AlertDialog.Builder(this); //cr�ation de la fenetre de dialogue
        builder.setMessage(message);//message qui d�pends de l'alerte
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new OkOnClickListener()); //cr�ation bouton pour fermer la fenetre
        AlertDialog dialog = builder.create();
        dialog.show();
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
             /*Toast.makeText(getApplicationContext(), "C'est parti !!!",
                     Toast.LENGTH_LONG).show();*/
    }
    }
    
    private final class ReturnOnclick implements //fonction qui g�re l'�v�nement du clique bouton "Retourne Menu" dans le dialogue de victoire
    DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) { 
			stopActivity(); 
		}
    }
    private final class RecommenceOnclick implements //fonction qui g�re l'�v�nement du clique bouton "Recommence" dans le dialogue de victoire
    DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			finish();
			startActivity(getIntent()); //red�marre l'activity avec les param�tres du d�but
			
		}
    }
    
    private void stopActivity(){
    	Intent i=new Intent(this,Accueil.class); //cr�e l'intent n�cessaire, pour d�marrer l'activity accueil
    	startActivity(i); //d�marre l'accueil
    	finish(); //arr�t de l'activity
    }
    }
    
    
