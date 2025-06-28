package state3.cartao;

public class ProntoParaPagamento extends CartaoEstado {

	public ProntoParaPagamento(Cartao cartao) {
		super(cartao);
	}

	@Override
	public void entrarPin(String pin) throws Exception {
		throw new Exception("PIN j\u00E1 validado.");
	}

	@Override
	public void fazerPagamento() throws Exception {
		// pagamento feito
//		this.getCartao().setEstado(new ProntoParaUsar(getCartao()));
		proxEstado();
	}

	@Override
	public void proxEstado() throws Exception {
		this.getCartao().setEstado(new ProntoParaUsar(getCartao()));
	}

	@Override
	public String toString() {
		return "ProntoParaPagamento";
	}

}
