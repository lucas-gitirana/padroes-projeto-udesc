package visitor3.visitor;

import visitor3.empresa.FuncNivelA;
import visitor3.empresa.FuncNivelB;
import visitor3.empresa.Gerente;

public class CalcFerias implements FuncionarioVisitor {

	private int total;
	
	@Override
	public void visitGerente(Gerente gerente) {
		gerente.setFeriasAGozar(gerente.getFeriasAGozar() - 10);
		total++;
	}

	@Override
	public void visitFuncNivelA(FuncNivelA funcionario) {
		if (funcionario.getSalario() >= 5000) {
			funcionario.setFeriasAGozar(funcionario.getFeriasAGozar() - 10);
			total++;
		}
	}

	@Override
	public void visitFuncNivelB(FuncNivelB funcionario) {
		if (funcionario.getSalario() >= 1500) {
			funcionario.setFeriasAGozar(funcionario.getFeriasAGozar() - 5);
			total++;
		}
	}

	public int getTotal() {
		return total;
	}

}
