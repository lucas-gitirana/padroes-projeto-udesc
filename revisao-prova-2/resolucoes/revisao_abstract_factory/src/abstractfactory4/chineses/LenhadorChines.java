package abstractfactory4.chineses;

import abstractfactory4.abstractfactory.Personagem;

public class LenhadorChines extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 1);
		return this.getRecurso();
	}

}
