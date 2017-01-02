package com.project.projetandroid;
import java.util.ArrayList;
import java.util.Iterator;


class reserveDes {
	private ArrayList<Des> reserve=new ArrayList<Des>();
	
	public reserveDes(ArrayList<Des> reserve){
		this.reserve=reserve;
		
	}

	protected ArrayList<Des> getReserve() {
		return reserve;
	}

	protected void setReserve(ArrayList<Des> reserve) {
		this.reserve = reserve;
	}
	
	protected void supprimeDes(Des a){
		/*Iterator<Des> iter = reserve.iterator();
		while( iter.hasNext()){
			if(iter.equals(a))
				
		}*/
		reserve.remove(a);
	}
	
	protected void ajoutDes(Des a){
		reserve.add(a);
	}
	
	protected Des pioche(){
		return null;
	}
	
	
	
	

}
