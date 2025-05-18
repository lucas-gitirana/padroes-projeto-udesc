package visitor6.visitor;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public class VisitorCustoProjeto extends Visitor{

	private double totalCusto;
	
	public VisitorCustoProjeto(Projeto projeto) {
		super(projeto);
		totalCusto = 0;
	}
	
	@Override
	public void visitProjeto(Funcionario func) {
		if (func.getProjetoAtual() != null && func.getProjetoAtual().equalsIgnoreCase(getProjeto().getNome())) {
			totalCusto += func.getSalario();
		}
	}

	public double getTotalCusto() {
		return totalCusto;
	}	

}
