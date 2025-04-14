package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Card;

public class CardController {

	public static final int ROWS = 2;
	public static final int COLUMNS = 3;
	
	private List<Observer> obss = new ArrayList<>();	
	
	private int win = 0;
	private boolean isFirst = true;
	private int compareCards = 0;
	private int holdCardRow = 0;
	private int holdCardColumn = 0;
	private Card[] cards = new Card[COLUMNS * ROWS];
	
	public CardController() {
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

	public void addObserver(Observer obs) {
		this.obss.add(obs);
	}
	
	public int getCardImgNum(int r, int c) {
		int index = (r * COLUMNS) + c ;
		return cards[index].getImgNum();
	}
	
	public void compare(int r, int c) {
		
		int index = (r * COLUMNS) + c ;
		
		if (isFirst) {
			compareCards = cards[index].getImgNum();
			holdCardRow = r;
			holdCardColumn = c;
			isFirst = false;
			
			notificaBloqueio(holdCardRow, holdCardColumn);
			
		} else {
			// cartas iguais
			if (compareCards == cards[index].getImgNum()) {
				win++;
				// encontrou todas entao fim de jogo
				if (win == COLUMNS) {
					notificaVitoria();

				} else {
					// encontrou um par entao desabilita para nao fazer mais pares
					cards[(holdCardRow * COLUMNS)+holdCardColumn].setCorrect(true);
					cards[index].setCorrect(true);
					notificaAcerto(r, c);
				}
			} else {
				// cartas diferentes
				notificaErro(r, c, holdCardRow, holdCardColumn);
			}
			isFirst = true;
		}
	}	

	private void notificaErro(int r, int c, int holdCardRow2, int holdCardColumn2) {
		for (Observer obs : obss) {
			obs.errou(r, c, holdCardRow2, holdCardColumn2);
		}
	}

	private void notificaAcerto(int r, int c) {
		for (Observer obs : obss) {
			obs.acertou(r, c);
		}		
	}

	private void notificaVitoria() {
		for (Observer obs : obss) {
			obs.venceu();
		}
	}

	private void notificaBloqueio(int holdCardRow2, int holdCardColumn2) {
		for (Observer obs : obss) {
			obs.bloqueiaCarta(holdCardRow2, holdCardColumn2);
		}
	}
}
