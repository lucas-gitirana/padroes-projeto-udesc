package visitor3.visitor;

import visitor3.empresa.FuncNivelA;
import visitor3.empresa.FuncNivelB;
import visitor3.empresa.Gerente;

public class CalcFolhaPagamento implements FuncionarioVisitor {

	private double totalFolha;
	
	@Override
	public void visitGerente(Gerente gerente) {
		totalFolha += gerente.getSalario();		
	}

	@Override
	public void visitFuncNivelA(FuncNivelA funcionario) {
		totalFolha += funcionario.getSalario();
	}

	@Override
	public void visitFuncNivelB(FuncNivelB funcionario) {
		totalFolha += funcionario.getSalario();
	}

	public double getTotalFolha() {
		return totalFolha;
	}

}
