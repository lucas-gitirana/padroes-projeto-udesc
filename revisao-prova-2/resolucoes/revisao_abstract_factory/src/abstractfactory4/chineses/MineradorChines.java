package abstractfactory4.chineses;

import abstractfactory4.abstractfactory.Personagem;

public class MineradorChines extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 0.2 + (recursoAtual * 0.01));
		return this.getRecurso();
	}

}
