package state4.pedido;

public class Registrado extends PedidoEstado {

    public Registrado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void analisar() throws Exception {
        this.getPedido().setEstado(new EmAnalise(this.getPedido()));
    }
}
