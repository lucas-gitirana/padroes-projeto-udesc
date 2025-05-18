package visitor6.visitor;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public class VisitorFimProjeto extends Visitor {

	public VisitorFimProjeto(Projeto projeto) {
		super(projeto);
	}

	@Override
	public void visitProjeto(Funcionario func) {
		if (func.getProjetoAtual() != null && func.getProjetoAtual().equalsIgnoreCase(getProjeto().getNome())) {
			func.setProjetoAtual(null);
		}
	}

}
