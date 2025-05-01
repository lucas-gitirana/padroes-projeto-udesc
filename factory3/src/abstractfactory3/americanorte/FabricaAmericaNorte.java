package abstractfactory3.americanorte;

import abstractfactory3.controle.abstractfactory.AbstractFreteFactory;
import abstractfactory3.controle.abstractfactory.Encomenda;

public class FabricaAmericaNorte extends AbstractFreteFactory {

	@Override
	public Encomenda prepararEncomendaExpresso() throws Exception {
		return new AmericaNorteExpresso();
	}

	@Override
	public Encomenda prepararEncomendaNormal() throws Exception {
		return new AmericaNorteNormal();
	}

}
