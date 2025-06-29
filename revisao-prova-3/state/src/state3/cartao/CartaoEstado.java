package state3.cartao;

public abstract class CartaoEstado {

	private Cartao cartao;

	public CartaoEstado(Cartao cartao) {
		this.cartao = cartao;
		this.cartao.setTentativas(0);
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public abstract void entrarPin(String pin) throws Exception;

	public abstract void fazerPagamento() throws Exception;

}
