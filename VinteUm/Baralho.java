package VinteUm;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	
	private ArrayList<Carta> cartas = new ArrayList<>();
	private int indexCarta;
	
	private static final String[] NAIPES = {"Ouros", "Espadas", "Copas", "Paus"};
	private static final String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "Ás"};
	
	public Baralho(){ 
		for (String naipe: NAIPES) {
			for(String face: FACES) {
				cartas.add(new Carta(naipe, face));
			}
		}
		embaralhar();
	}
	
	public void embaralhar() {
		Collections.shuffle(cartas);
		
		indexCarta = 0;
	}
	
	public Carta comprarCarta() {
		if (indexCarta < cartas.size()) {
			return cartas.get(indexCarta++);
		}
		return null;
	}
	
	public boolean estaVazio() { 
		return indexCarta >= cartas.size();
	}
	
	public int cartasBaralho() {
		return cartas.size() - indexCarta;
	}
	
	
}
