package com.project.projetandroid;
import java.util.ArrayList;




class ReserveDes {
	private ArrayList<Des> reserve=new ArrayList<Des>();
	
	
	//constructeur
	public ReserveDes(ArrayList<Des> reserve){
		this.reserve=reserve;	
	}
	
	//gettes/setters
	protected ArrayList<Des> getReserve() {
		return reserve;
	}

	protected void setReserve(ArrayList<Des> reserve) {
		this.reserve = reserve;
	}
	
	/*méthode pour piocher, on choisis aléatoirement des dés de la réserve
	 * on est affecte le résultat à la main du joueur en paramètre*/
	protected void pioche(Joueur a){
		if(!a.isJouer()&&!reserve.isEmpty()){ //on vérifie si la réserve est vide, et s'il n'a pas joué
		int max=13; //nombre de dés
		int i=0; int choix;
		Des[] main=new Des[3];
		while(i<=2){
			choix=(int)(Math.random()*(max)); //choix du dé
			if(reserve.get(choix)!=null){ //verification que ce n'est pas null
				(reserve.get(choix)).faceTire(); //on lance le dés pour obtenir la face
				main[i]=reserve.get(choix); //on met dans le tableur le dé tiré
				reserve.remove(choix); //on retire le dé de la réserve
				max=max-1; //diminue le max, vu que la liste est plus petite
				i++;
			}
			
		}
		
		a.setMain(main);
		a.setJouer(true); //le joueur a pioché, on passe le paramètre à true;
	}
	
	}
	
	/*relance des dés si le joueur a au moins une casserole, et si la réserve n'est pas vide
	 * si le dé est égale à casserole, on retire le dé (changement face)*/
	protected void relance(Joueur a){
		if(!reserve.isEmpty()&&a.aCasserole()){
		Des[] main=a.getMain();
		int choix;
		for(int i=0;i<3;i++){
			if(main[i]==null){
				choix=(int) (Math.random()*(reserve.size()));
				if(reserve.get(choix)!=null){
					(reserve.get(choix)).faceTire();
					main[i]=reserve.get(choix);
					reserve.remove(choix);}
			}
			else if(main[i].getFaceRetournee().equals("Casserole"))
				main[i].faceTire();
		}
		
	}
	}
}

