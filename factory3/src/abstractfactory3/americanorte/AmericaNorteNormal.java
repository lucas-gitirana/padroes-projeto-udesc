package abstractfactory3.americanorte;

import abstractfactory3.controle.abstractfactory.Destino;
import abstractfactory3.controle.abstractfactory.Encomenda;

public class AmericaNorteNormal extends Encomenda {

	@Override
	public double getPreco() throws Exception {
		this.setDestino(Destino.AMERICADONORTE);
		
		if (this.getPeso() <= 0 || this.getCubagem() <= 0) {
			throw new Exception("O peso e a cubagem precisam ser maiores do que 0.");
		}
		
		float modificacao = (float) 1.0;
		if (this.getCubagem() <= 21600)
			modificacao = (float) 0.3;
		else if (this.getCubagem() <= 27000) 
			modificacao = (float) 0.7;
		
		return this.getCubagem() * 0.009 + this.getPeso()*modificacao*0.005;
	}

}
