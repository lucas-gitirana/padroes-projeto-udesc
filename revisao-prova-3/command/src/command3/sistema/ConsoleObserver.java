package command3.sistema;

import command3.observer.Observer;

public class ConsoleObserver implements Observer {

	@Override
	public void buscouDados(String[][] dados) {
		
		for (String[] umDados: dados) {
			System.out.println(umDados[0] + " " + umDados[1]);
		}
		
	}

	@Override
	public void adicionouPessoa(String[][] dados) {
		System.out.println("Adicionada pessoa: " + dados[0][0] + " - " + dados[0][1] );
	}

	@Override
	public void removeuPessoa(String[][] dados) {
		System.out.println("Removida a pessoa de ID " + dados[0][0] + " - " + dados[0][1] );
	}

	@Override
	public void buscouPessoa(String[][] dados) {
		System.out.println("Pessoa buscada: "  + dados[0][0] + " - " + dados[0][1] );
	}

}
