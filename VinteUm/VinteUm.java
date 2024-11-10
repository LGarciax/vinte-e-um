package VinteUm;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VinteUm {

	public static void main(String[] args) {
		
		String[] opcao = {"Sim", "Não"};
		
		ArrayList<Jogador> jogadores = new ArrayList<>();
		Baralho baralho = new Baralho();

		
		baralho.embaralhar();
		
		//Jogadores
		
		int quantidadeJogadores = Integer.parseInt(JOptionPane.showInputDialog("Quantos Jogadores?"));
		
		for(int i = 0; i < quantidadeJogadores; i++) { 
		String nome = JOptionPane.showInputDialog("Nome do " + (i+1) + "º jogador?");
		Jogador jogador = new Jogador(nome);
		jogadores.add(jogador);
		}
		
		// Jogo
		
		for(int i = 0; i < quantidadeJogadores; i++) {
			Carta carta = baralho.comprarCarta();
			Jogador jogador = jogadores.get(i);
			jogador.addCarta(carta);
			
			String maoJogador = jogador.jogador() + ": \n" + jogador.toString() + "\n" + "Valor da Mão: " + jogador.valorMao();
			
			JOptionPane.showMessageDialog(null, maoJogador);
			
			while(true) { 
				
				if(baralho.estaVazio()) {
					break;
				}
				String mensagem = jogador.jogador() + "\n" + "Você tem " + jogador.numeroCartas() + " cartas e sobram " + baralho.cartasBaralho() + " no baralho comprar carta?";
				int compra = JOptionPane.showOptionDialog(null, mensagem, "Comprar Carta?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
				if(compra == 0) {
					carta = baralho.comprarCarta();
					jogador.addCarta(carta);
				}
				
				maoJogador = jogador.jogador() + ": \n" + jogador.toString() + "\n" + "Valor da Mão: " + jogador.valorMao();
				
				JOptionPane.showMessageDialog(null, maoJogador);
				
				if(jogador.valorMao() > 21) { 
					JOptionPane.showMessageDialog(null, "Você Estouro");
					break;
				}
				
				if(compra == 1) {
					break;
				}
			}
			
		}
		
		// Resultado
		
		ArrayList<Jogador> vencedores = new ArrayList<>();
		ArrayList<Jogador> jogadoresEstouraram = new ArrayList<>();
		ArrayList<Jogador> jogadoresPerderam = new ArrayList<>();

		int maiorValor = 0;

	
		for (Jogador jogador : jogadores) {
		    int valorMao = jogador.valorMao();

		    
		    if (valorMao > 21) {
		        jogadoresEstouraram.add(jogador);
		    } else {
		      
		        if (valorMao > maiorValor) {
		            maiorValor = valorMao;
		        }
		    }
		}

		for (Jogador jogador : jogadores) {
		    int valorMao = jogador.valorMao();

		    if (valorMao == maiorValor && valorMao <= 21) {
		        vencedores.add(jogador);
		    } else if (valorMao <= 21) {
		        jogadoresPerderam.add(jogador);
		    }
		}


		StringBuilder resultado = new StringBuilder();

		
		if (vencedores.size() > 1) {
		    resultado.append("Empate! Vencedores com ").append(maiorValor).append(" pontos:\n");
		    for (Jogador vencedor : vencedores) {
		        resultado.append(vencedor.jogador()).append(" (").append(vencedor.valorMao()).append(" pontos)\n");
		    }
		} else if (vencedores.size() == 1) {
		    resultado.append("Vencedor: ").append(vencedores.get(0).jogador())
		            .append(" com ").append(vencedores.get(0).valorMao()).append(" pontos.\n");
		} else {
		    resultado.append("Nenhum jogador venceu.\n");
		}


		if (!jogadoresEstouraram.isEmpty()) {
		    resultado.append("\nJogadores que estouraram:\n");
		    for (Jogador jogador : jogadoresEstouraram) {
		        resultado.append(jogador.jogador()).append(" (").append(jogador.valorMao()).append(" pontos)\n");
		    }
		}

	
		if (!jogadoresPerderam.isEmpty()) {
		    resultado.append("\nJogadores que não venceram e não estouraram:\n");
		    for (Jogador jogador : jogadoresPerderam) {
		        resultado.append(jogador.jogador()).append(" (").append(jogador.valorMao()).append(" pontos)\n");
		    }
		}

		
		JOptionPane.showMessageDialog(null, resultado.toString(), "Resultado Final", JOptionPane.INFORMATION_MESSAGE);
		
		
		
		
		

	}

}
