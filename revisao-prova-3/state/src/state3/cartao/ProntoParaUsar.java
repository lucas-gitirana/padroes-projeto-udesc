package state3.cartao;

public class ProntoParaUsar extends CartaoEstado {

	public ProntoParaUsar(Cartao cartao) {
		super(cartao);
	}

	@Override
	public void entrarPin(String pin) throws Exception {
		if (pin.equals("XXXX")) {
			getCartao().setTentativas(0);
			getCartao().setEstado(new ProntoParaPagamento(getCartao()));
		} else {
			getCartao().setTentativas(getCartao().getTentativas()+1);
			proxEstado();
			throw new Exception("Erro de PIN");
		}
	}

	@Override
	public void fazerPagamento() throws Exception {
		throw new Exception("N\u00E3o podes fazer o pagamento.");
	}

	@Override
	public void proxEstado() throws Exception {
		if (getCartao().getTentativas() >= 3) {
			this.getCartao().setEstado(new Bloqueado(this.getCartao()));
		}
	}

	@Override
	public String toString() {
		return "ProntoParaUsar";
	}
}
