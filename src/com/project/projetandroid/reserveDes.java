package com.project.projetandroid;
import java.util.ArrayList;


class ReserveDes {
	private ArrayList<Des> reserve=new ArrayList<Des>();
	
	public ReserveDes(ArrayList<Des> reserve){
		this.reserve=reserve;	
	}
	

	protected ArrayList<Des> getReserve() {
		return reserve;
	}

	protected void setReserve(ArrayList<Des> reserve) {
		this.reserve = reserve;
	}
	
	
	protected void pioche(Joueur a){
		int max=13;
		int i=0; int choix;
		Des[] main=new Des[3];
		while(i<=2){
			choix=((int) Math.random()*(max));
			if(reserve.get(choix)!=null){
				(reserve.get(choix)).faceTire();
				main[i]=reserve.get(choix);
				reserve.remove(choix);
				i++;
			}else
				choix=((int) Math.random()*(max));	
		}
		a.setMain(main);
	}
	
	protected int nbrTirage(Des[] main){
		int cpt=0; 
		for(int i=0;i<main.length;i++)
			if(main[i]==null)
				cpt++;
		return cpt;
	}
	
	protected int positionNull(Des[] main){
		int pos=0;
		for(int i=0; i<main.length;i++)
			if(main[i]==null)
				return pos;
		return pos;
	}
	
	protected void relance(Joueur a){
		Des[] main=a.getMain();
		int tirage=nbrTirage(main);int choix;
		while(tirage>=0){
			choix=((int) Math.random()*reserve.size());
			(reserve.get(choix)).faceTire();
			main[positionNull(main)]=reserve.get(choix);
			reserve.remove(reserve.get(choix));
			tirage--;
		}
		
	}
}
