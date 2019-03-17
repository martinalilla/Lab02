package it.polito.tdp.alien;
import java.util.*;

public class DizionarioAlieno {
	
	private LinkedList<Word> dizionario=new LinkedList<Word>();
	
	public void stampa() {
		for(Word s: dizionario) {
			System.out.println(s.getParola()+s.getTraduzione());
		}
	}
	
	public boolean addWord(String parola, String traduzione) {
		parola=parola.toLowerCase();
		traduzione.toLowerCase();
		Word temp=new Word(parola, traduzione);
		boolean trovata=false;
		for(Word s:dizionario) {
			/*if(s.getParola().compareTo(parola)!=0) {
				dizionario.add(temp);
				
			}*/
			if(s.getParola().compareTo(parola)==0) {
				s.aggiorna(temp.getTraduzione());
				trovata=true;
				break;
				
			}
			
			
			
		}
		if(trovata==false) {
			dizionario.add(temp);
		}
		return trovata;
		
		
	}
	
	/*public boolean formatoNonValido(String parola) {
		boolean b=true; 
		String pattern="[a-z]*";
		if(parola.matches(pattern)) {
			b=false;
		}
		return b;
	}*/
	
	public String translateWord(String parola) {
		parola.toLowerCase();
		for(Word s:dizionario) {
			if(s.getParola().compareTo(parola)==0) {
				return s.getTraduzione();
			}
		}
		return null;
	}
	
	public void elimina() {
		dizionario.clear();
	}

}
