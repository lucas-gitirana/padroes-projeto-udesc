package controle;

import java.util.ArrayList;
import java.util.List;

import model.Jogada;

public class GameController {

	private List<Observador> obss;
	
	private List<Jogada> jogadas = new ArrayList<>();
	private int score_human;
	private int score_win = 0;
	private int score_tie = 0;

	public GameController() {
		this.obss = new ArrayList<>();
	}
	
	public int getScore_human() {
		return score_human;
	}

	public int getScore_win() {
		return score_win;
	}

	public int getScore_tie() {
		return score_tie;
	}
	
	public List<Jogada> getJogadas() {
		return jogadas;
	}

	public void addObservador(Observador obs) {
		this.obss.add(obs);
	}
	
	public void computeWinner(int choice_human) {
		int choice_computer = (int) (Math.random() * 3) + 1;
		
		Jogada jogada = new Jogada(choice_human, choice_computer);
		jogadas.add(jogada);
		
		switch (jogada.getVitorioso()) {
			case 12:
				if (choice_human == 2)
					score_human = 1;
					notificaVitoriaPapel(jogada);
				break;
			case 13:
				if (choice_human == 1)
					score_human = 1;
					notificaVitoriaPedra(jogada);
				break;
			case 23:
				if (choice_human == 3)
					score_human = 1;
					notificaVitoriaTesoura(jogada);
				break;
			default:
				score_human = 2;
				score_tie += 1;
				notificaEmpate(jogada);
		}
	}
	
	public int getJogadorVencedor() {
		int result = score_human;
		if (score_human == 1) {
			score_human = 0;
			score_win += 1;
		} else if (score_human == 2) {
			score_human = 0;
		}
		return result;
	}
	
	private void notificaVitoriaPapel(Jogada jogada) {
		for (Observador obs : obss) {
			obs.venceuPapel(jogada.getMinha(), jogada.getPc());
		}
	}
	
	private void notificaVitoriaPedra(Jogada jogada) {
		for (Observador obs : obss) {
			obs.venceuPedra(jogada.getMinha(), jogada.getPc());
		}
	}

	private void notificaVitoriaTesoura(Jogada jogada) {
		for (Observador obs : obss) {
			obs.venceuTesoura(jogada.getMinha(), jogada.getPc());
		}
	}
	
	private void notificaEmpate(Jogada jogada) {
		for (Observador obs : obss) {
			obs.empate(jogada.getMinha(), jogada.getPc());
		}	
	}
	
}
