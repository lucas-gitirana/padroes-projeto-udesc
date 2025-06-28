package command3.sistema;

import command3.observer.Observer;

public class ConsoleObserver implements Observer {

	@Override
	public void buscouDados(String[][] dados) {
		
		for (String[] umDados: dados) {
			System.out.println(umDados[0] + " " + umDados[1]);
		}
		
	}

}
