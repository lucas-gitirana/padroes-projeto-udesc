package abstractfactory4.gregos;

import abstractfactory4.abstractfactory.AbstractCivilizacaoFactory;
import abstractfactory4.abstractfactory.Personagem;

public class FabricaGregos extends AbstractCivilizacaoFactory {

	@Override
	public Personagem criarColhedor() {
		return new ColhedorGrego();
	}

	@Override
	public Personagem criarLenhador() {
		return new LenhadorGrego();
	}

	@Override
	public Personagem criarMinerador() {
		return new MineradorGrego();
	}

}
