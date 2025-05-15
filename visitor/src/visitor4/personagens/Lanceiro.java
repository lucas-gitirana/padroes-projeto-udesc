package visitor4.personagens;

import visitor4.visitor.AtaqueVisitor;

public class Lanceiro extends Personagem {

	public Lanceiro() {
		super(10, 1);
	}

	@Override
	public void accept(AtaqueVisitor visitor) throws Exception {
		visitor.visitLanceiro(this);
	}

}
