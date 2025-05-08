package visitor4.personagens;

import visitor4.visitor.AtaqueVisitor;

public class Catapulta extends Personagem {

	public Catapulta() {
		super(8, 5);
	}

	@Override
	public void accept(AtaqueVisitor visitor) throws Exception {
		visitor.visitCatapulta(this);
	}

	
	
}
