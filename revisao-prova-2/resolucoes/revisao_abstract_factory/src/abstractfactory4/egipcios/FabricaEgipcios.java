package abstractfactory4.egipcios;

import abstractfactory4.abstractfactory.AbstractCivilizacaoFactory;
import abstractfactory4.abstractfactory.Personagem;

public class FabricaEgipcios extends AbstractCivilizacaoFactory {

	@Override
	public Personagem criarColhedor() {
		return new ColhedorEgipcio();
	}

	@Override
	public Personagem criarLenhador() {
		return new LenhadorEgipcio();
	}

	@Override
	public Personagem criarMinerador() {
		return new MineradorEgipcio(); 
	}

}
