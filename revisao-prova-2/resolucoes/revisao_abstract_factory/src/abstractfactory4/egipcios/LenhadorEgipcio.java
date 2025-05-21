package abstractfactory4.egipcios;

import abstractfactory4.abstractfactory.Personagem;

public class LenhadorEgipcio extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 0.5 + (recursoAtual * 0.01));
		return this.getRecurso();
	}

}
