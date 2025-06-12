package command3.command;

import command3.dao.BancoPessoas;
import command3.observer.Observer;

public class GetCommand extends Command {
	
	private String[] dados = new String[2];

	public GetCommand(Observer observer, String[] dados) {
		super(observer);
		this.dados = dados;
	}
	
	public String[] getDados() {
		return dados;
	}
	
	public int getId() {
		return Integer.parseInt(this.dados[0]);
	}

	@Override
	public void execute() {
		this.observer.buscouPessoa(BancoPessoas.getInstance().getPessoa(getId()));
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}

}
