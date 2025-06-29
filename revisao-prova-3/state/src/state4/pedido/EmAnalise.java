package state4.pedido;

public class EmAnalise extends PedidoEstado {

    public EmAnalise(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void suspender() throws Exception {
        this.getPedido().setEstado(new Pendente(this.getPedido()));
    }

    @Override
    public void aprovar() throws Exception {
        this.getPedido().setEstado(new Aprovado(this.getPedido()));
    }

    @Override
    public void cancelar() throws Exception {
        this.getPedido().setEstado(new Cancelado(this.getPedido()));
    }
}
