package command5.command;

import command5.BancoMusicas;
import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class AdicionarMusica extends Command {

	private int musica;
	
	public AdicionarMusica(CarrinhoCompras cc, Observer obs, int musica) {
		super(cc, obs);
		this.musica = musica;
	}

	@Override
	public void execute() {
		Musica m = BancoMusicas.getInstancia().getMusicas().get(musica);
		this.cc.add(m);
	}

	@Override
	public void undo() {
		Musica m = BancoMusicas.getInstancia().getMusicas().get(musica);
		this.cc.getProdutos().remove(m);
	}

	@Override
	public void redo() {
		execute();
	}

}
