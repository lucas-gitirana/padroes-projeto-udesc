package abstractfactory4.egipcios;

import abstractfactory4.abstractfactory.Personagem;

public class MineradorEgipcio extends Personagem {

	@Override
	public double produzirRecurso() {
		double recursoAtual = this.getRecurso();
		this.setRecurso(recursoAtual + 2);
		return this.getRecurso();
	}

}
