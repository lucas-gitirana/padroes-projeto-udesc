package command5.command;

import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class PrecoTotal extends Command {

	public PrecoTotal(CarrinhoCompras cc, Observer obs) {
		super(cc, obs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		float precoTotal = 0;
		for (Musica mus:cc.getProdutos()) {
			precoTotal += mus.getPreco();
		}
		this.obs.precoTotal(precoTotal);
		
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
