package decorator4;

public class SanduicheFechado implements Sanduiche {
	
	private double preco;

	public double getPreco() {
		return 1.0;
	}

	@Override
	public String toString() {
		return "(Tudo colocado no prato)";
	}

}
