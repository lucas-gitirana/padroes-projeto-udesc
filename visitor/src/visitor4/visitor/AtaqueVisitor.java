package visitor4.visitor;

import visitor4.personagens.Arqueiro;
import visitor4.personagens.Catapulta;
import visitor4.personagens.Lanceiro;
import visitor4.personagens.Personagem;

public abstract class AtaqueVisitor {

	public abstract void visitArqueiro(Arqueiro arqueiro);
	public abstract void visitCatapulta(Catapulta catapulta);
	public abstract void visitLanceiro(Lanceiro lanceiro);

	private Personagem personagem;
	
	public AtaqueVisitor(Personagem p) {
		this.personagem = p;
	}
	
	public Personagem getPersonagem() {
		return personagem;
	};
	
}
