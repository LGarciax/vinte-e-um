package classeRandom;

import java.util.Random;
import java.util.Scanner;

public class VersaoSimples {

	public static void main(String[] args) {
		int j1 = 0, j2 = 0, j3 = 0;
		
		int carta, escolha;
		
		Scanner sc = new Scanner(System.in);
		
		Random random = new Random();
		
		for(int i = 1; i <= 3; i++) { // Laço de jogador, roda 3 vezes uma para cada jogador.
			// Gerar carta inicial para o jogador
			
			carta = random.nextInt(10) + 1; // Gera numeros entre 0 e 9 e soma 1 para gerar resultados entre 1 e 10
			
			if(i == 1) { // Define qual é o jogador da vez e entrega a carta para ele
				j1 = carta;
			} else if(i == 2) {
				j2 = carta;
			} else {
				j3 = carta;
			}
			
			while(true) { //Loop infinito enquanto o jogador decidir comprar cartas.
				
				System.out.println("Jogador " + i + " comprar uma carta? 1 - Sim, 2 - Não");
				escolha = sc.nextInt();
				
				if(escolha == 1) {
					carta = random.nextInt(10) + 1; // gera uma carta
					if(i == 1) {
						j1 += carta;
					} else if(i == 2) {
						j2 += carta;
					} else {
						j3 += carta;
					}
				} else {
					break; // caso o jogador não escolha comprar uma carta, a instrução break quebra o loop infinito (break serve para sair do loop)
				}
			
			}
			
			
		}
		
		// Mostrar Resultados
		
		System.out.println("Jogador 1: " + j1);
		System.out.println("Jogador 2: " + j2);
		System.out.println("Jogador 3: " + j3);

	}

}
