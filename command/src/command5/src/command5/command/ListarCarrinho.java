package command5.command;

import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class ListarCarrinho extends Command {

	public ListarCarrinho(CarrinhoCompras cc, Observer obs) {
		super(cc, obs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		for (Musica mus:cc.getProdutos()) {
			this.obs.listarCarrinho(mus);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
