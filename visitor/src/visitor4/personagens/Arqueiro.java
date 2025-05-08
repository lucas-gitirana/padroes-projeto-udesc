package visitor4.personagens;

import visitor4.visitor.AtaqueVisitor;

public class Arqueiro extends Personagem {

	public Arqueiro() {
		super(15, 2);
	}

	@Override
	public void accept(AtaqueVisitor visitor) throws Exception {
		visitor.visitArqueiro(this);
	}

}
