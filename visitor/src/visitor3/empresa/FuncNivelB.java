package visitor3.empresa;

import visitor3.visitor.FuncionarioVisitor;

public class FuncNivelB extends Funcionario {

	public FuncNivelB(String nome, double salario) {
		super(nome, salario, 30);
	}

	@Override
	public void accept(FuncionarioVisitor visitor) {
		visitor.visitFuncNivelB(this);
	}

}
