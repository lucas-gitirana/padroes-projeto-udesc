package command3.command;

import command3.dao.BancoPessoas;
import command3.observer.Observer;

public class NewCommand extends Command {
	
	private String[] dados = new String[2];

	public NewCommand(Observer observer, String[] dados) {
		super(observer);
		this.dados = dados;
	}
	
	public String[] getDados() {
		return dados;
	}
	
	public void atualizarId(int id) {
		this.dados[0] = String.valueOf(id);
	}
	
	public int getId() {
		return Integer.parseInt(this.dados[0]);
	}

	@Override
	public void execute() {
		String nome = getDados()[1];
		int id = BancoPessoas.getInstance().addPessoa(getId(), nome);
		this.observer.adicionouPessoa(id);
		atualizarId(id);
	}

	@Override
	public void undo() {
		BancoPessoas.getInstance().removerPessoa(getId());
		this.observer.undoAction();
	}

	@Override
	public void redo() {
		execute();
	}

}
