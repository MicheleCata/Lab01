package it.polito.tdp.parole.model;

import java.util.*;
import java.util.List;

public class Parole {
	
	List <String> parole;
		
	public Parole() {
		parole = new LinkedList<>(); // oppure con ArrayList<>()
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public class ComparatoreParole implements Comparator<String>{

		@Override
		public int compare(String p1, String p2) {
			return p1.compareTo(p2);
		}
		
	}
	
	public List<String> getElenco() {
		
		Collections.sort(parole, new  ComparatoreParole());
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	public String toString() {
		String stampa ="";
		for (String s: parole) {
			stampa+= s+"\n";
		}
		return stampa;
		
	}
	
	public void cancellaParola(String p) {
		parole.remove(p);
	}
	
	

}
