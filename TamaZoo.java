package ing.unibs.esercitazioni.tamazoo;

import java.util.*;

public class TamaZoo {

	private List<Tamagotchi> listaTama;
	private static final String INTESTAZIONE_ZOO = "Elenco tamagotchi rimasti:\n\n";
	private static final String ELENCO_TAMA = "%d - %s%n";
	
	public TamaZoo() {
		
		listaTama = new ArrayList<Tamagotchi>();
		
	}
	
	public void controllaTama() {
		
		for (int i = 0; i < listaTama.size(); i++) {
			
			if (listaTama.get(i).morto()) {
				
				listaTama.remove(i);
				i--;
				
			}
			
		}
		
	}
	
	public void aggiungiTama(Tamagotchi nuovoTama) {
		
		listaTama.add(nuovoTama);
		
	}
	
	public void daiCarezze(int n) {
		
		for (Tamagotchi tama: listaTama)
			tama.daiCarezze(n);
		
	}
	
	public void daiBiscotti(int n) {
		
		for (Tamagotchi tama: listaTama)
			tama.daiBiscotti(n);
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder(INTESTAZIONE_ZOO);
		
		for (int i = 0; i < listaTama.size(); i++)
			builder.append(String.format(ELENCO_TAMA, (i + 1), listaTama.get(i).toString()));
		
		return builder.toString();
		
	}
	
}
