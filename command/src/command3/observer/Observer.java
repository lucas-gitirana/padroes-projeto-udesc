package command3.observer;

import command3.modelo.Pessoa;

public interface Observer {

	void buscouDados(String[][] dados);
	void buscouPessoa(Pessoa pessoa);
	void adicionouPessoa(int id);
	void removeuPessoa(int id);
	void undoAction();

}
