package state4.pedido;

public class Pendente extends PedidoEstado {

    public Pendente(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void retomar() throws Exception {
        this.getPedido().setEstado(new EmAnalise(this.getPedido()));
    }

    @Override
    public void cancelar() throws Exception {
        this.getPedido().setEstado(new Cancelado(this.getPedido()));
    }
}
