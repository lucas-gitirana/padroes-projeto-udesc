package command5.observer;

import command5.Musica;

public interface Observer {

	void listarCarrinho(Musica mus);
	void precoTotal(float preco);
	void tamanhoMusicas(int tamTotal);
	
}
