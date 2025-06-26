package decorator3;

public class Cripto extends TextoDecorator {

	public Cripto(Texto texto) {
		super(texto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTexto() {
//		return super.getTexto();
		return "CRIPTO";
	}
	
	

}
