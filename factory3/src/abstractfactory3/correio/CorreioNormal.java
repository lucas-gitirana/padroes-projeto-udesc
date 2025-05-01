package abstractfactory3.correio;

import abstractfactory3.controle.abstractfactory.Destino;
import abstractfactory3.controle.abstractfactory.Encomenda;

public class CorreioNormal extends Encomenda {

	@Override
	public double getPreco() throws Exception {
		float volume = getCubagem();
		
		switch(getDestino()) {
			case NORTE:
				return volume * 0.03;
			case CENTROOESTE:
				return volume * 0.04;
			case NORDESTE:
				return volume * 0.02;
			case SUDESTE:
				return volume * 0.01;
			case SUL:
				return volume * 0.01;
			case AMERICALATINA:
				return volume * 0.07;
			case AMERICADONORTE:
				return volume * 0.10;
			case EUROPA:
				return volume * 0.15;
			case AFRICA:
				return volume * 0.25;
			case ASIA:
				return volume * 0.17;
			case OCEANIA:
				return volume * 0.30;
			default:
				return 0;
		}
	}

}
