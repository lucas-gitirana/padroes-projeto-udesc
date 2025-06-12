package command3.sistema;

import command3.modelo.Pessoa;
import command3.observer.Observer;

public class ConsoleObserver implements Observer {

	@Override
	public void buscouDados(String[][] dados) {
		
		for (String[] umDados: dados) {
			System.out.println(umDados[0] + " " + umDados[1]);
		}
		
	}

	@Override
	public void adicionouPessoa(int id) {
		System.out.println("Pessoa " + id + " adicionada com sucesso!");
	}

	@Override
	public void undoAction() {
		System.out.println("Ação desfeita!");		
	}

	@Override
	public void removeuPessoa(int id) {
		System.out.println("Pessoa " + id + " removida com sucesso!");		
	}

	@Override
	public void buscouPessoa(Pessoa pessoa) {
		System.out.println("Pessoa encontrada: " + pessoa.toString());
	}

}
