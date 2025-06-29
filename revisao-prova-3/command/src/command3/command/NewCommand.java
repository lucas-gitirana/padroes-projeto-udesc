package command3.command;

import command3.dao.BancoPessoas;
import command3.observer.Observer;

public class NewCommand extends Command {

	private String[] dados;
	private int id;

	public NewCommand(Observer observer, String[] dados) {
		super(observer);
		this.dados = dados;
	}

	@Override
	public void execute() {
		int id = Integer.parseInt(dados[0]);
		String nome = dados[1];
		this.id = BancoPessoas.getInstance().addPessoa(id, nome);

		String[][] res = new String[1][2];
		res[0][0] = String.valueOf(id);
		res[0][1] = nome;
		this.observer.adicionouPessoa(res);
	}

	@Override
	public void undo() {
		BancoPessoas.getInstance().removerPessoa(this.id);
	}

	@Override
	public void redo() {
		execute();
	}

}
