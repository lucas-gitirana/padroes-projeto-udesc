package abstractfactory4.gregos;

import abstractfactory4.abstractfactory.Personagem;

public class MineradorGrego extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 3);
		return this.getRecurso();
	}

}
