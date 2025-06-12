package command3.command;

import command3.dao.BancoPessoas;
import command3.modelo.Pessoa;
import command3.observer.Observer;

public class DeleteCommand extends Command {
	
	private String[] dados = new String[2];
	private Pessoa pessoa;

	public DeleteCommand(Observer observer, String[] dados) {
		super(observer);
		this.dados = dados;
	}
	
	public int getId() {
		return Integer.parseInt(this.dados[0]);
	}
	
	@Override
	public void execute() {
		Pessoa pessoaRemovida = BancoPessoas.getInstance().removerPessoa(getId());
		this.pessoa = pessoaRemovida;
		this.observer.removeuPessoa(pessoaRemovida.getId());
	}

	@Override
	public void undo() {
		int id = BancoPessoas.getInstance().addPessoa(this.pessoa.getId(), this.pessoa.getNome());
		this.observer.adicionouPessoa(id);
	}

	@Override
	public void redo() {
		execute();
	}

}
