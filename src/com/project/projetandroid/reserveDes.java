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
		if(!a.isJouer()){
		int max=13;
		int i=0; int choix;
		Des[] main=new Des[3];
		while(i<=2){
			choix=(int)(Math.random()*(max-1));
			if(reserve.get(choix)!=null){
				(reserve.get(choix)).faceTire();
				main[i]=reserve.get(choix);
				reserve.remove(choix);
				i++;
			}else
				choix=((int) Math.random()*(max));	
			max=reserve.size();
		}
		
		a.setMain(main);
		a.setJouer(true);
	}
		else{
			a.setMain(a.getMain());
		}
	
	}
	
	
	protected void relance(Joueur a){
		Des[] main=a.getMain();
		int choix;
		for(int i=0;i<3;i++){
			if(main[i]==null){
				choix=(int) (Math.random()*(reserve.size()));
				if(reserve.get(choix)!=null){
					(reserve.get(choix)).faceTire();
					main[i]=reserve.get(choix);
					reserve.remove(choix);
					System.out.println("lol");}
			}
			else if(main[i].getFaceRetournee().equals("Casserole"))
				main[i].faceTire();
		}
		
	}
}

