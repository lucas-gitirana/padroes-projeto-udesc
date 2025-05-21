package abstractfactory4.gregos;

import abstractfactory4.abstractfactory.Personagem;

public class LenhadorGrego extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 1.5);
		return this.getRecurso();
	}

}
