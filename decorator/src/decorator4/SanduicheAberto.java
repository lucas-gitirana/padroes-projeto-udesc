package decorator4;

public class SanduicheAberto implements Sanduiche {
	
	private double preco;

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "(Tudo dentro da caixa)";
	}

}
