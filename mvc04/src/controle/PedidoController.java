package controle;

import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import model.Produto;

public class PedidoController {

	List<Observer> obss;
	
	private int idxProduto;
	private List<Produto> tabelaProdutos = new ArrayList<>();
	private List<Pedido> tabelaPedidos = new ArrayList<>();

	public PedidoController() {
		this.obss = new ArrayList<>();
		
		tabelaProdutos.add(new Produto("cal\u00E7a", 83));
		tabelaProdutos.add(new Produto("camisa", 57));
		tabelaProdutos.add(new Produto("gravata", 15.7));
		tabelaProdutos.add(new Produto("tenis", 235.8));
	}
	
	public void addObserver(Observer obs) {
		this.obss.add(obs);
	}
	
	public List<Produto> getTabelaProdutos() {
		return tabelaProdutos;
	}

	public List<Pedido> getTabelaPedidos() {
		return tabelaPedidos;
	}

	public void anterior() {
		idxProduto = (idxProduto - 1);
		if (idxProduto == -1)
			idxProduto = tabelaProdutos.size() - 1;
		
		for (Observer obs : obss) {
			obs.anterior();
		}
	}

	public void posterior() {
		idxProduto = (idxProduto + 1) % tabelaProdutos.size();
		for (Observer obs : obss) {
			obs.posterior();
		}
	}

	public void adicionar() {
		Produto prod = tabelaProdutos.get(idxProduto);
		Pedido alvo = null;
		for (Pedido ped : tabelaPedidos) {
			if (ped.getProduto() == prod) {
				alvo = ped;
				break;
			}
		}
		if (alvo == null) {
			alvo = new Pedido(prod);
			tabelaPedidos.add(alvo);
		} else
			alvo.addQtdade();
		
		for (Observer obs : obss) {
			obs.adicionar();
		}
	}

	public void concluir() {
		tabelaPedidos.clear();
		idxProduto = 0;
		
		for (Observer obs : obss) {
			obs.concluir();
		}
	}

	public double getTotalPedido() {
		double total = 0;
		for (Pedido ped : tabelaPedidos) {
			total += ped.getPcoTotal();
		}
		return total;
	}
	
	
}
