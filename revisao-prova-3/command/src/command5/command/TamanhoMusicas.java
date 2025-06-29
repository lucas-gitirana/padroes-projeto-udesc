package command5.command;

import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class TamanhoMusicas implements Command {

    private CarrinhoCompras cc;
    private Observer observer;

    public TamanhoMusicas(CarrinhoCompras cc, Observer observer) {
        this.cc = cc;
        this.observer = observer;
    }

    @Override
    public void execute() {
        int tamTotal = 0;
        for (Musica mus:cc.getProdutos()) {
            tamTotal += mus.getTamanho();
        }

        this.observer.showTamanhoMusicas(tamTotal);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
