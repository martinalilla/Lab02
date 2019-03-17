package it.polito.tdp.alien;
import java.util.*;

public class WordEnhanced {
	private String parola;
	private LinkedList <String> traduzioni=new LinkedList <String>();
	
	
	public WordEnhanced(String parola) {
		super();
		this.parola = parola;
	}
	
	public void addWord(String word) {
		traduzioni.add(word);
	}
	
	public String traduzioni() {
		String st="";
		for(String s: traduzioni) {
			st+=s+"\n";
		}
		return st;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public LinkedList<String> getTraduzioni() {
		return traduzioni;
	}

	public void setTraduzioni(LinkedList<String> traduzioni) {
		this.traduzioni = traduzioni;
	}
	
	
	
	

}
