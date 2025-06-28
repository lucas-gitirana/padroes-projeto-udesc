package decorator2;

public abstract class PedidoDecorador implements PedidoBase {

    private PedidoBase componente;

    public PedidoDecorador(PedidoBase componente) {
        this.componente = componente;
    }

    public PedidoBase getComponente() {
        return componente;
    }

    public void setComponente(PedidoBase componente) {
        this.componente = componente;
    }

    @Override
    public void concluir() {
        componente.concluir();
    }

    @Override
    public double getTotal() {
        return componente.getTotal();
    }
}
