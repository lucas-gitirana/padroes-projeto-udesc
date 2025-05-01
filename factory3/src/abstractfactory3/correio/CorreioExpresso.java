package abstractfactory3.correio;

import java.util.Arrays;
import java.util.List;

import abstractfactory3.controle.abstractfactory.Destino;
import abstractfactory3.controle.abstractfactory.Encomenda;

public class CorreioExpresso extends Encomenda {

	@Override
	public double getPreco() throws Exception {
		
		Destino[] destinos = {Destino.NORTE, Destino.NORDESTE, Destino.CENTROOESTE, Destino.SUL, Destino.SUDESTE};
		if (!Arrays.asList(destinos).contains(this.getDestino())) {
			throw new Exception("Selecione um destino válido");
		}
		
		if (this.getDestino() == Destino.NORTE || this.getDestino() == Destino.NORDESTE)
			return this.getPeso()*0.05;
		
		if (this.getDestino() == Destino.CENTROOESTE)
			return this.getPeso()*0.075;
		
		if (this.getDestino() == Destino.SUL || this.getDestino() == Destino.SUDESTE)
			return this.getPeso()*0.025;
		
		return 0;
	}

}
