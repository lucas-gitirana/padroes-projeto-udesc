package abstractfactory4.gregos;

import abstractfactory4.abstractfactory.Personagem;

public class ColhedorGrego extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 1 + (recursoAtual * 0.01));
		return this.getRecurso();
	}

}
