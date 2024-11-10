package VinteUm;

import java.util.ArrayList;

public class Jogador {
	
	private ArrayList<Carta> mao = new ArrayList<>();
	private String nomeJogador;
	private int valorMao;
	private int numeroCartas;
	
	public Jogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
		this.valorMao = 0;
		this.numeroCartas = 0;
	}
	
	public void addCarta(Carta carta) {
		this.mao.add(carta);
		this.numeroCartas++;
	}
	
	public int valorMao() { 
		this.valorMao = 0;
		boolean temAs = false;
		boolean temFace = false;
		
		for(Carta carta: mao) {
			 if (carta.getFace().equals("Ás")) {
		            temAs = true;
		        }
		        
		        else if (carta.getFace().equals("Rei") || carta.getFace().equals("Valete") || carta.getFace().equals("Dama")) {
		            temFace = true;
		        }
			
			this.valorMao += carta.getValor();
		}
		
		if (temAs && temFace && mao.size() == 2) {
	        return 21;
	    }
		
		return this.valorMao;
	}
	public String jogador() {
		return this.nomeJogador;
	}
	
	public int numeroCartas() {
		return this.numeroCartas;
	}
	
	@Override
	public String toString() { 
		StringBuilder cartasMao = new StringBuilder();
		for(Carta carta: mao) {
			cartasMao.append(carta).append("\n");
		}
		return cartasMao.toString();
	}

}
