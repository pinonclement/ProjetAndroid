package com.project.projetandroid;


public class Joueur {

	private String pseudo;
	private int score_final;
	private int score_tempo;
	private int fourchette;
	private boolean jouer;
	private Des[] main=new Des[3];

	protected int getScore_tempo() {
		return score_tempo;
	}
	
	
	protected boolean isJouer() {
		return jouer;
	}
	protected void setJouer(boolean jouer) {
		this.jouer = jouer;
	}
	protected int getFourchette() {
		return fourchette;
	}

	protected void setFourchette(int fourchette) {
		this.fourchette = fourchette;
	}

	protected void setScore_tempo(int score_tempo) {
		this.score_tempo = score_tempo;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getScore_final() {
		return score_final;
	}

	public void setScore_final(int score_final) {
		this.score_final = score_final;
	}


	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		score_final = 0;
		fourchette=0;
		score_tempo=0;
		
	}
	public Des[] getMain() {
		return main;
	}
	public void setMain(Des[] main) {
		this.main = main;
	}
	
	protected void analyseTempo(){
		for(int i=0;i<3;i++)
		{
			if(main[i]!=null){
				
				if(main[i].getFaceRetournee().equals("Pate")&&this.getFourchette()!=3)
				{
					score_tempo++;
					main[i]=null;
				}
				else if(main[i].getFaceRetournee().equals("Fourchette"))
				{
					fourchette++;
					main[i]=null;
				}
			}
				
		}
	}
	
	protected boolean aCasserole(){
		if(fourchette!=3){
			for(int i=0;i<3;i++){
				if(main[i]!=null)
					if(main[i].getFaceRetournee().equals("Casserole"))
						return true;
			}
		}
		return false;
	}
	
	protected boolean gagne(){
		if(score_final>=13)
			return true;
		return false;
	}
	
	protected void perdre(){
		if(fourchette>=3)
			score_tempo=0;
	}
	
	protected void gain(){
		score_final+=score_tempo;
	}
	



}