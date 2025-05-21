package abstractfactory4.chineses;

import abstractfactory4.abstractfactory.AbstractCivilizacaoFactory;
import abstractfactory4.abstractfactory.Personagem;

public class FabricaChineses extends AbstractCivilizacaoFactory {

	@Override
	public Personagem criarColhedor() {
		return new ColhedorChines();
	}

	@Override
	public Personagem criarLenhador() {
		return new LenhadorChines();
	}

	@Override
	public Personagem criarMinerador() {
		return new MineradorChines();
	}

}
