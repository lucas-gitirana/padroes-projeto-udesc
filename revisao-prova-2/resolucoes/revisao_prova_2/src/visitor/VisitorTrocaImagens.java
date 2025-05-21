package visitor;

import model.Card;

public class VisitorTrocaImagens extends Visitor {

	@Override
	public void visitCard(Card card) {
		int operador = (card.getImgNum() <= 3) ? 3 : -3;
		card.setImgNum(card.getImgNum() + operador);
	}

}
