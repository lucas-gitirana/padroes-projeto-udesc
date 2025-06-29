package command5.command;

import command5.BancoMusicas;
import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class AddMusica implements Command {

    private CarrinhoCompras cc;
    private int opMusica;
    private Observer observer;

    public AddMusica(CarrinhoCompras cc, int opMusica, Observer observer) {
        this.cc = cc;
        this.opMusica = opMusica;
        this.observer = observer;
    }

    @Override
    public void execute() {
        Musica m = BancoMusicas.getInstancia().getMusicas().get(opMusica);
        cc.add(m);
        this.observer.adicionouMusica(m.getNome());
    }

    @Override
    public void undo() {
        Musica m = BancoMusicas.getInstancia().getMusicas().get(opMusica);
        cc.remove(m);
    }

    @Override
    public void redo() {
        execute();
    }
}
