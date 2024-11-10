package VinteUm;

public class Carta {
	
	private String face;
	private String naipe;
	private int valor;
	
	public Carta(String naipe, String face) {
		this.naipe = naipe;
		this.face = face;
		
		if(face.contains("Ás")) {
			this.valor = 1;
		} else if(face.contains("Dama") || face.contains("Valete") || face.contains("Rei")) {
			this.valor = 10;
		}else {
			this.valor = Integer.parseInt(face);
		}
	}
	
	public String getNaipe() {
		return this.naipe;
	}
	
	public String getFace() {
		return this.face;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		return face + " de " + naipe;
	}

}
