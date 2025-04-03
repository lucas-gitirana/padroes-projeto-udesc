package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Card;

public class CardController {
	
	private List<Observador> obss = new ArrayList<>();
	
	public static final int ROWS = 2;
	public static final int COLUMNS = 3;
	private Card[] cards = new Card[COLUMNS * ROWS];
	
	private int compareCards = 0;
	private int holdCardRow = 0;
	private int holdCardColumn = 0;
	private boolean isFirst = true;
	private int win = 0;
	
	public void addObservador(Observador obs) {
		this.obss.add(obs);
	}
	
	public Card[] getCards() {
		return this.cards;
	}
	
	public void embaralhar() {
		Random rgen = new Random(); 
		int z = 1;
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Card(-1, -1, z, false);
			if (i % 2 == 1) {
				z++;
			}
		}
		
		// --- embaralhar
		for (int i = 0; i < cards.length; i++) {
			int randomPosition = rgen.nextInt(cards.length);
			Card temp = cards[i];

			cards[i] = cards[randomPosition];
			cards[i].setX(i / COLUMNS);
			cards[i].setY(i % COLUMNS);

			cards[randomPosition] = temp;

			temp.setX(randomPosition / COLUMNS);
			temp.setY(randomPosition % COLUMNS);
		}
		
		for (Observador obs : obss) {
			obs.embaralhar();
		}
	}

	public void virarCarta(int r, int c) {
		int index = (r * COLUMNS) + c ;
		
//		ImageIcon tempImg = new ImageIcon("imagens/Card" + cards[index].getImgNum() + ".jpg");
//		imgLabel[r][c].setIcon(tempImg);

		// guarda as variaveis da primeira carta a ser virada
		if (isFirst) {
			compareCards = cards[index].getImgNum();
			holdCardRow = r;
			holdCardColumn = c;
//			memButtons[holdCardRow][holdCardColumn].setEnabled(false);
			isFirst = false;
			
			for (Observador obs : obss) {
				obs.virarPrimeiraCarta(r,c);
			}
			
		} else {
			// cartas iguais
			if (compareCards == cards[index].getImgNum()) {
				win++;
				// encontrou todas entao fim de jogo
				if (win == COLUMNS) {
//					JOptionPane.showMessageDialog(null, "Voc\u00EA venceu!");
//					dispose();
					
					for (Observador obs : obss) {
						obs.notificarVitoria();
					}

				} else {
					// encontrou um par entao desabilita para nao fazer mais pares
					cards[(holdCardRow * COLUMNS)+holdCardColumn].setCorrect(true);
					cards[index].setCorrect(true);
					
//					JOptionPane.showMessageDialog(null, "Voc\u00EA encontrou um par!");
//					memButtons[r][c].setEnabled(false);
					
					for (Observador obs : obss) {
						obs.notificarMatch(r, c);
					}
				}
			} else {
				// cartas diferentes
//				JOptionPane.showMessageDialog(null, "Gah! Erradas!");
//				memButtons[holdCardRow][holdCardColumn].setEnabled(true);
//				tempImg = versoCarta;
//				imgLabel[r][c].setIcon(tempImg);
//				imgLabel[holdCardRow][holdCardColumn].setIcon(tempImg);
			}
			isFirst = true;
		}
	}
}
