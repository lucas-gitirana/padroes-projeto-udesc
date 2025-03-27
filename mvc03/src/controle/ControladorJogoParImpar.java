package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.Mao;

public class ControladorJogoParImpar {
	
	private List<Observador> observadores = new ArrayList<Observador>();
	private List<Mao> maos = new ArrayList<>();
	private int minhaVit, pcVit;
	private int idxMao;
	private Random sorteio = new Random();
	
	public void addObservador(Observador observador) {
		this.observadores.add(observador);
	}
	
	public void novo() {
		maos.clear();
		minhaVit = 0; 
		pcVit = 0;
		
		for (Observador observador : observadores) {
			observador.iniciouJogo();
		}
	}
	
	public void posterior() {
		idxMao = (idxMao + 1) % 6;
		
		for (Observador observador : observadores) {
			observador.posteriorJogo();
		}
	}
	
	public void jogar(boolean isPar) {
		int maoPC = sorteio.nextInt(6);

		Mao mao = new Mao(isPar, maoPC, idxMao);
		maos.add(mao);
		
		// 1a INTERAÇÃO COM A TELA
		for (Observador observador : observadores) {
			observador.maoPc(maoPC);
		}
		
		boolean vencePar = ((maoPC + idxMao)%2) == 0;
		if (mao.isPar() == vencePar) {
			minhaVit++;
			if (minhaVit == 3) {
				// 2a INTERAÇÃO COM A TELA
				for (Observador observador : observadores) {
					observador.minhaVit();
				}
			}
		} else {
			pcVit++;
			if (pcVit == 3) {
				// 3a INTERAÇÃO COM A TELA
				for (Observador observador : observadores) {
					observador.pcVit();
				}
			}
		}
	}

	public Mao getMao(int index) {
		return maos.get(index);
	}

	public int sizeMao() {
		return maos.size();
	}
	
}
