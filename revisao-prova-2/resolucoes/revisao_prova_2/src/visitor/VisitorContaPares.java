package visitor;

import model.Card;

public class VisitorContaPares extends Visitor{
	
	private int contCartasCorretas;
	
	public VisitorContaPares() {
		this.contCartasCorretas = 0;
	}	

	@Override
	public void visitCard(Card card) {
		if (card.isCorrect()) {
			contCartasCorretas++;
		}
	}
	
	public int getParesCorretos() {
		return contCartasCorretas / 2;
	}
	
	
}
