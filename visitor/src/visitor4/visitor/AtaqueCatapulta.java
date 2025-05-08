package visitor4.visitor;

import visitor4.personagens.Arqueiro;
import visitor4.personagens.Catapulta;
import visitor4.personagens.Lanceiro;
import visitor4.personagens.Personagem;

public class AtaqueCatapulta extends AtaqueVisitor {

	public AtaqueCatapulta(Personagem p) {
		super(p);
	}

	@Override
	public void visitArqueiro(Arqueiro arqueiro) {
		arqueiro.setPontoVida(arqueiro.getPontoVida() - (getPersonagem().getForcaAtaque() + 1));
	}

	@Override
	public void visitCatapulta(Catapulta catapulta) {
		catapulta.setPontoVida(catapulta.getPontoVida() - (getPersonagem().getForcaAtaque() + 2));
	}

	@Override
	public void visitLanceiro(Lanceiro lanceiro) {
		lanceiro.setPontoVida(lanceiro.getPontoVida() - getPersonagem().getForcaAtaque());
	}

}
