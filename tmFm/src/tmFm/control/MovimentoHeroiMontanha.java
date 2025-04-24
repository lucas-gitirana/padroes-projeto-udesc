package tmFm.control;

import tmFm.model.Heroi;
import tmFm.model.HeroiMontanha;
import tmFm.model.Montanha;
import tmFm.model.Peca;

public class MovimentoHeroiMontanha extends MovimentoHeroi {

	@Override
	protected Heroi criarPeca() {
		return new HeroiMontanha();
	}

	@Override
	protected boolean validarOutrosTiposCasas(Peca peca) {
		return peca.getClass() == Montanha.class;
	}

}
