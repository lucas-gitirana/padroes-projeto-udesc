package command5.command;

import command5.CarrinhoCompras;
import command5.Musica;
import command5.observer.Observer;

public class ListarCarrinho implements Command {

    private CarrinhoCompras cc;
    private Observer observer;

    public ListarCarrinho(CarrinhoCompras cc, Observer observer) {
        this.cc = cc;
        this.observer = observer;
    }

    @Override
    public void execute() {
        this.observer.listarMusicas(cc.getProdutos());
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
