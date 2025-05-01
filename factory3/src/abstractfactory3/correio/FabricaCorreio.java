package abstractfactory3.correio;

import abstractfactory3.controle.abstractfactory.AbstractFreteFactory;
import abstractfactory3.controle.abstractfactory.Encomenda;

public class FabricaCorreio extends AbstractFreteFactory {

	@Override
	public Encomenda prepararEncomendaExpresso() throws Exception {
		return new CorreioExpresso();
	}

	@Override
	public Encomenda prepararEncomendaNormal() throws Exception {
		return new CorreioNormal();
	}

}
