package it.polito.tdp.alien;
import java.util.*;

public class DizionarioAlieno {
	
	private LinkedList<Word> dizionario=new LinkedList<Word>();
	private LinkedList<WordEnhanced> dizionariomultiplo=new LinkedList<WordEnhanced>();
	
	
	public void stampa() {
		for(Word s: dizionario) {
			System.out.println(s.getParola()+s.getTraduzione());
		}
	}
	
	public boolean addWord(String parola, String traduzione) {
		parola=parola.toLowerCase();
		traduzione.toLowerCase();
		Word temp=new Word(parola, traduzione);
		WordEnhanced w=new WordEnhanced(parola);
		//w.addWord(traduzione);
		//dizionariomultiplo.add(w);
		boolean trovata=false;
		for(WordEnhanced s:dizionariomultiplo) {
			
			if(s.getParola().compareTo(parola)==0) {
				//s.aggiorna(temp.getTraduzione());
				s.addWord(traduzione);
				trovata=true;
				break;
				
			}
				
		}
		if(trovata==false) {
			w.addWord(traduzione);
			dizionariomultiplo.add(w);
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
		for(WordEnhanced s:dizionariomultiplo) {
			if(s.getParola().compareTo(parola)==0) {
				return s.traduzioni();
			}
		}
		return null;
	}
	
	public void elimina() {
		dizionario.clear();
	}

}
