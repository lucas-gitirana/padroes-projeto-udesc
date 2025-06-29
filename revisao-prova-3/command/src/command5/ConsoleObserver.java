package command5;


import command5.observer.Observer;

import java.util.List;

public class ConsoleObserver implements Observer {

	@Override
	public void adicionouMusica(String nome) {
		System.out.println("Adicionou música " + nome);
	}

	@Override
	public void listarMusicas(List<Musica> produtos) {
		for (Musica mus : produtos) {
			System.out.println("> " + mus);
		}
	}

	@Override
	public void showTamanhoMusicas(int tamTotal) {
		System.out.println("> " + tamTotal + " MB");
	}

	@Override
	public void showPrecoTotal(float precoTotal) {
		System.out.println("> R$ " + precoTotal);
	}
}
