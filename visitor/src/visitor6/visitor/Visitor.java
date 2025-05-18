package visitor6.visitor;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public abstract class Visitor {

	private Projeto projeto;

	public Visitor(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public abstract void visitProjeto(Funcionario func);

	public Projeto getProjeto() {
		return projeto;
	}
	
}
