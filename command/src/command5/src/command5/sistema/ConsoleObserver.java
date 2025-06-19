package command5.sistema;

import command5.Musica;
import command5.observer.Observer;

public class ConsoleObserver implements Observer {

	@Override
	public void listarCarrinho(Musica mus) {
		System.out.println("> " + mus);
	}

	@Override
	public void precoTotal(float preco) {
		System.out.println("> R$ " + preco);
	}

	@Override
	public void tamanhoMusicas(int tamTotal) {
		System.out.println("> " + tamTotal + " MB");		
	}

}
