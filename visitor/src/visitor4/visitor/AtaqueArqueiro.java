package visitor4.visitor;

import visitor4.personagens.Arqueiro;
import visitor4.personagens.Catapulta;
import visitor4.personagens.Lanceiro;
import visitor4.personagens.Personagem;

public class AtaqueArqueiro extends AtaqueVisitor {

	public AtaqueArqueiro(Personagem p) {
		super(p);
	}

	@Override
	public void visitArqueiro(Arqueiro arqueiro) {
		if (arqueiro == getPersonagem()) return;
		arqueiro.setPontoVida(arqueiro.getPontoVida() - getPersonagem().getForcaAtaque());
	}

	@Override
	public void visitCatapulta(Catapulta catapulta) {
		catapulta.setPontoVida(catapulta.getPontoVida() - getPersonagem().getForcaAtaque());
	}

	@Override
	public void visitLanceiro(Lanceiro lanceiro) {
		lanceiro.setPontoVida(lanceiro.getPontoVida() - (getPersonagem().getForcaAtaque() - 1));
	}

}
