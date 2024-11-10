package classeRandom;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class VersaoMediaAvancada {

	public static void main(String[] args) {

		int quantidadeJogadores;

		ArrayList<Integer> jogadores = new ArrayList<>(); // ArrayList permite gerar listas sem tamanho fixo, podemos ter o numero de jogadores que quisermos
		
		ArrayList<Integer> baralho = new ArrayList<>(); 
		
		String[] opcao = {"Sim", "Não"};
		
		Random random = new Random();
		
		// Gerando um baralho de 52 cartas (apenas valores 4 copias de 1 a 9 e 16 cartas com valor 10 (10, J, Q, K)
		// Adicionando as cartas de 1 a 9
		for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < 4; j++) {
                baralho.add(i);
            }
        }
		
		// Adicionando 16 cartas de valor 10 (4 copias de 10, J, Q, K)
            for (int i = 0; i < 16; i++) {
                baralho.add(10);
            }
            
            quantidadeJogadores = Integer.parseInt(JOptionPane.showInputDialog("Quantos Jogadores?")); // pede a quantidade de jogadores
            
            for(int i = 1; i <= quantidadeJogadores; i++) { // Loop até o numero de jogadores cadastrados
            	int valorMao = 0; // inicia a mão de cada jogador sem cartas.
            	
            	int index = random.nextInt(baralho.size()); // gera numeros aleatorios até o numero de cartas no baralho
            	
            	valorMao = baralho.get(index); // pega uma carta do baralho e entrega ao jogador
            	baralho.remove(index); // remove aquela carta do baralho
            	int contagemCartas = 1; // inicia a contagem de cartas do jogador
            	
            	while(true) { // Loop enquanto o jogador quiser cartas.
            		
            		if(baralho.size() == 0) { // verifica se o baralho não esta vazio e impede a compra de novas cartas. 
            			jogadores.add(valorMao);
            			JOptionPane.showMessageDialog(null, "Baralho vazio", "Vazio", JOptionPane.ERROR_MESSAGE);
            			break;
            		}
            		
            		// Oferece a opção de comprar cartas ao jogador.
            		String mensagem = "Jogador " + i + "\n" + " você tem " + contagemCartas + " cartas e sobram " + baralho.size() + " no baralho comprar carta?"; 
            	int compra = JOptionPane.showOptionDialog(null, mensagem, "Comprar Carta?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);
            		
            	
            	if(compra == 0) { // Caso o jogador compre uma carta
            			index = random.nextInt(baralho.size()); // escolhe uma carta
            			valorMao += baralho.get(index); // entrega a carta ao jogador
                    	baralho.remove(index); // remove essa carta do baralho
                    	contagemCartas++; // conta quantas cartas o jogador possui
            	}else { // jogador não quis mais cartas
            		jogadores.add(valorMao); // entrega o valor da mão ao jogador
            		break; // termina o loop
            	}
            		
            	}   
            	
            	if(baralho.size() == 0) { // verifica se o baralho não esta vazio e impede o jogo de continuar. 
        			JOptionPane.showMessageDialog(null, "Baralho vazio", "Vazio", JOptionPane.ERROR_MESSAGE);
        			break;
        		}
            }
            
         // Descobrir o vencedor e determinar empates e estouros
            
            int melhorPontuacao = 0; // int para achar a melhor pontuação 
            ArrayList<Integer> vencedores = new ArrayList<>(); // uma lista de vencedores
            StringBuilder estouraram = new StringBuilder(); // StringBuilder é um metodo para criar Strings, quando você vai usar um loop ele é superior a somente + na string atual
            StringBuilder naoGanharam = new StringBuilder();

            
            for (int i = 0; i < jogadores.size(); i++) {
                int pontuacao = jogadores.get(i); // atribui pontuação ao valor da mão do jogador
                if (pontuacao > 21) { // Se a pontuação for maior que 21 adiciona o jogador a string de estouro
                   
                    estouraram.append("Jogador ").append(i + 1).append(" com ").append(pontuacao).append(" pontos\n");
                } else if (pontuacao > melhorPontuacao) { // se a pontuação for melhor que a maior pontuação atual
                    
                    melhorPontuacao = pontuacao; // muda a melhor pontuação
                    vencedores.clear(); // limpa a lista de vencedores
                    vencedores.add(i + 1); // adiciona o vencedor a lista
                } else if (pontuacao == melhorPontuacao) {  // Caso empate
                   
                    vencedores.add(i + 1); // adiciona o jogador empatado a lista de vencedores
                }
            }

            // Gerar a String de jogadores que não ganharam, mas não estouraram tbm
            
            for (int i = 0; i < jogadores.size(); i++) {
                int pontuacao = jogadores.get(i);
                if (pontuacao <= 21 && !vencedores.contains(i + 1)) { // verifica que é menor que 21 a pontuação e que o jogador não é um dos vencedores
                    naoGanharam.append("Jogador ").append(i + 1).append(" com ").append(pontuacao).append(" pontos\n");
                }
            }

            // Gerar String do resultado
            
            StringBuilder resultado = new StringBuilder();
            if (!vencedores.isEmpty()) { // Se alguem venceu
                if (vencedores.size() == 1) { // 1 jogador venceu
                    resultado.append("O vencedor é o Jogador ").append(vencedores.get(0))
                            .append(" com ").append(melhorPontuacao).append(" pontos!\n");
                } else { // mais de um jogador venceu
                    resultado.append("Empate entre os jogadores:\n");
                    for (int vencedor : vencedores) { // É um FOR especial para listas e arrays, ele roda um numero de vezes igual ao numero de velores guardados
                        resultado.append("Jogador ").append(vencedor).append(" com ").append(melhorPontuacao).append(" pontos\n");
                    }
                }
            } else { // se ninguem venceu
                resultado.append("Todos os jogadores estouraram.\n");
            }

            if (estouraram.length() > 0) { // se alguem estourou
                resultado.append("\nJogadores que estouraram:\n").append(estouraram);
            }

            if (naoGanharam.length() > 0) { // imprime todos os que não estouraram, mas não ganharam
                resultado.append("\nJogadores que não estouraram, e não ganharam:\n").append(naoGanharam);
            }

            JOptionPane.showMessageDialog(null, resultado.toString()); // Imprime todos os resultados
        }

	}


