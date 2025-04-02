package controle;

import model.Produto;

public interface Observador {
	public void novoPedido();
	public void anterior();
	public void posterior();
	public void inicializaProduto(Produto p);
	public void addProdutoPedido();
	public void concluirPedido();
	
}
