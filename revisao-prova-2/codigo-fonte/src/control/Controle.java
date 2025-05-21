package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Card;

public class Controle {
	
	// constantes: nao tem problema mante-las publicas
	public static final int ROWS = 2;
	public static final int COLUMNS = 3;

	private List<Observer> obss = new ArrayList<>();
	
	public void addObserver(Observer obs) {
		this.obss.add(obs);
	}
	
	private Card[] cards = new Card[COLUMNS * ROWS];
	private int compareCards = 0;
	private int holdCardRow = 0;
	private int holdCardColumn = 0;
	private boolean isFirst = true;
	private int win = 0;

	public Controle() {
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

	}

	public void virouCarta(int r, int c) {

		int index = (r * Controle.COLUMNS) + c ;
		
		for (Observer obs:obss) {
			obs.virouACarta(r, c, cards[index].getImgNum());
		}
		
		// guarda as variaveis da primeira carta a ser virada
		if (isFirst) {
			compareCards = cards[index].getImgNum();
			holdCardRow = r;
			holdCardColumn = c;
			isFirst = false;
			
			for (Observer obs:obss) {
				obs.virouAPrimeiraCarta(r, c);
			}
			
		} else {
			// cartas iguais
			if (compareCards == cards[index].getImgNum()) {
				win++;
				// encontrou todas entao fim de jogo
				if (win == Controle.COLUMNS) {
					
					for (Observer obs:obss) {
						obs.venceuJogo(r, c, compareCards);
					}

				} else {
					// encontrou um par entao desabilita para nao fazer mais pares
					cards[(holdCardRow * Controle.COLUMNS)+holdCardColumn].setCorrect(true);
					cards[index].setCorrect(true);

					for (Observer obs:obss) {
						obs.encontrouPar(r, c, compareCards);
					}

				}
			} else {
				// cartas diferentes
				
				for (Observer obs:obss) {
					obs.paresDiferentes(holdCardRow, holdCardColumn, r, c);
				}
				
				
			}
			isFirst = true;
		}
		
	}
}
