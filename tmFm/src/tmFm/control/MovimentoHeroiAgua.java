package tmFm.control;

import tmFm.model.Agua;
import tmFm.model.Heroi;
import tmFm.model.HeroiAgua;
import tmFm.model.Peca;

public class MovimentoHeroiAgua extends MovimentoHeroi {

	@Override
	protected Heroi criarPeca() {
		return new HeroiAgua();
	}

	@Override
	protected boolean validarOutrosTiposCasas(Peca peca) {
		return peca.getClass() == Agua.class;
	}

}
