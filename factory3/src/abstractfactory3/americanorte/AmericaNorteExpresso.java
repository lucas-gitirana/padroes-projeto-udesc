package abstractfactory3.americanorte;

import abstractfactory3.controle.abstractfactory.Encomenda;

public class AmericaNorteExpresso extends Encomenda {

	@Override
	public double getPreco() throws Exception {
		throw new Exception("Esse tipo de frete n�o � suportado");
	}

}
