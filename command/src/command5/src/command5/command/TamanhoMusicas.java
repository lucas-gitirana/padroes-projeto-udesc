package command5.command;

import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class TamanhoMusicas extends Command {

	public TamanhoMusicas(CarrinhoCompras cc, Observer obs) {
		super(cc, obs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		int tamTotal = 0;
		for (Musica mus:cc.getProdutos()) {
			tamTotal += mus.getTamanho();
		}
		this.obs.tamanhoMusicas(tamTotal);
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
