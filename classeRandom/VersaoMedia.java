package classeRandom;

import java.util.Random;
import java.util.Scanner;

public class VersaoMedia {

	public static void main(String[] args) {
		int[] jogador = {0, 0, 0}; // Array para guardar o resultado de 3 jogadores, jogador1 = jogador[0], jogador2 = jogador[1], jogador3 = jogador[2]
		// você pode usar 3 variaveis (J1, J2, J3), e definir o jogador no loop com if-elses ou switchs
		
		int carta, escolha;
		
		Scanner sc = new Scanner(System.in);
		
		Random random = new Random();
		
		for(int i = 0; i < 3; i++) { // Laço de jogador, roda 3 vezes uma para cada jogador.
			// Gerar carta inicial para o jogador
			
			carta = random.nextInt(10) + 1; // Gera numeros entre 0 e 9 e soma 1 para gerar resultados entre 1 e 10
			
			jogador[i] = carta; // Atribui o valor da carta inicial para o jogador "i"
			
			while(true) { //Loop infinito enquanto o jogador decidir comprar cartas.
				
				System.out.println("Jogador " + (i+1) + " comprar uma carta? 1 - Sim, 2 - Não");
				escolha = sc.nextInt();
				
				if(escolha == 1) {
					carta = random.nextInt(10) + 1; // gera uma carta
					jogador[i] += carta; // Equivale a jogador[i] = jogador[i] + carta somando a proxima carta a mão atual.
				} else {
					break; // caso o jogador não escolha comprar uma carta, a instrução break quebra o loop infinito (break serve para sair do loop)
				}
			
			}
			
			
		}
		
		// Mostrar Resultados
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Jogador " + (i+1) + ": " + jogador[i] + " pontos");
			if(jogador[i] > 21) { 
				System.out.print("estourou \n");
			} else if(jogador[i] == 21) {
				System.out.print("venceu \n");
			}
			
			System.out.println("===========================");
		}
		
		

	}

}
