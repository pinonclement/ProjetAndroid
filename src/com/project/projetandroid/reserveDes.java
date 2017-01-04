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
	
	/*m�thode pour piocher, on choisis al�atoirement des d�s de la r�serve
	 * on est affecte le r�sultat � la main du joueur en param�tre*/
	protected void pioche(Joueur a){
		if(!a.isJouer()&&!reserve.isEmpty()){ //on v�rifie si la r�serve est vide, et s'il n'a pas jou�
		int max=13; //nombre de d�s
		int i=0; int choix;
		Des[] main=new Des[3];
		while(i<=2){
			choix=(int)(Math.random()*(max)); //choix du d�
			if(reserve.get(choix)!=null){ //verification que ce n'est pas null
				(reserve.get(choix)).faceTire(); //on lance le d�s pour obtenir la face
				main[i]=reserve.get(choix); //on met dans le tableur le d� tir�
				reserve.remove(choix); //on retire le d� de la r�serve
				max=max-1; //diminue le max, vu que la liste est plus petite
				i++;
			}
			
		}
		
		a.setMain(main);
		a.setJouer(true); //le joueur a pioch�, on passe le param�tre � true;
	}
	
	}
	
	/*relance des d�s si le joueur a au moins une casserole, et si la r�serve n'est pas vide
	 * si le d� est �gale � casserole, on retire le d� (changement face)*/
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

