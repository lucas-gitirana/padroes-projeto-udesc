package decorator4;

public class Hamburguer extends SanduicheDecorator {

	public Hamburguer(Sanduiche componente) {
		super(componente);
	}

	@Override
	public double getPreco() {
		return super.getPreco() + 2;
	}

	@Override
	public String toString() {
		return "Hamburguer " + super.toString();
	}

}
