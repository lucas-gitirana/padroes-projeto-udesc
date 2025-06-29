package command5.observer;

import command5.Musica;

import java.util.List;

public interface Observer {

	void adicionouMusica(String nome);
	void listarMusicas(List<Musica> produtos);
	void showTamanhoMusicas(int tamTotal);
	void showPrecoTotal(float precoTotal);
}
