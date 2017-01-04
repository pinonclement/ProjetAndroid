package com.project.projetandroid;


public class Joueur {

	private String pseudo;
	private int score_final;
	private int score_tempo;
	private int fourchette;
	private boolean jouer; // sert à empecher la pioche infini
	private Des[] main=new Des[3];

	
	/*getters/setters*/
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
	public Des[] getMain() {
		return main;
	}
	public void setMain(Des[] main) {
		this.main = main;
	}

	/*création du joueur avec comme paramètre un pseudo, chaque variable vaut 0 puisque la partie n'a pas commencé*/
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		score_final = 0;
		fourchette=0;
		score_tempo=0;		
	}
	/*Analyse de la main, si à l'indice i, le dés n'est pas null, on regarde sa face, si pate, on augmente 
	 * le score temporaire de 1 en enlevant le dés, si fourchette, on augmente fourchette de 1 et on enleve le dés de la main*/
	protected void analyseTempo(){
		for(int i=0;i<3;i++)
		{
			if(main[i]!=null){
				
				if(main[i].getFaceRetournee().equals("Pate"))
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
	/*On regarde la main, si la joueur a au moins une casserole return vrai sinon false*/
	protected boolean aCasserole(){
			for(int i=0;i<3;i++){
				if(main[i]!=null)
					if(main[i].getFaceRetournee().equals("Casserole"))
						return true;
			}
		return false;
	}
	/*on regarde le score du joueur, si le joueur a au moins 13 points return vrai sinon false*/
	protected boolean gagne(){
		if(score_final>=13)
			return true;
		return false;
	}
	/*si le joueur a plus de fourchette, le score tempo est égale à 0, il ne gagnera aucun point à ce tour*/
	protected void perdre(){
		if(fourchette>=3)
			score_tempo=0;
	}
	/*on ajoute les points temporaires au points totaux*/
	protected void gain(){
		score_final+=score_tempo;
	}
	



}