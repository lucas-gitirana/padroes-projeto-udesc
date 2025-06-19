package command5.command;

import command5.CarrinhoCompras;
import command5.observer.Observer;

public abstract class Command {
	
	protected CarrinhoCompras cc = new CarrinhoCompras();
	protected Observer obs;
	
	public Command(CarrinhoCompras cc, Observer obs) {
		super();
		this.cc = cc;
		this.obs = obs;
	}

	public abstract void execute();
	
	public abstract void undo();
	
	public abstract void redo();
	
}
