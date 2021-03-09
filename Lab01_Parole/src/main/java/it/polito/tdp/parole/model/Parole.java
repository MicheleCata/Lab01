package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List <String> parole;
		
	public Parole() {
		parole = new LinkedList<>();
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
		List <String> pp = new LinkedList<>(parole);
		Collections.sort(pp, new  ComparatoreParole());
		return pp;
	}
	
	public void reset() {
		parole.clear();
	}

}
