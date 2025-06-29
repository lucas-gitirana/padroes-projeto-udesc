package state4.pedido;

public class Aprovado extends PedidoEstado{

    public Aprovado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void atender() throws Exception {
        this.getPedido().setEstado(new Atendido(this.getPedido()));
    }

    @Override
    public void cancelar() throws Exception {
        this.getPedido().setEstado(new Cancelado(this.getPedido()));
    }
}
