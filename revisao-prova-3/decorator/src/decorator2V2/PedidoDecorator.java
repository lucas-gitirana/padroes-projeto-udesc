package decorator2V2;

public class PedidoDecorator implements PedidoBase {

    private PedidoBase componente;

    public PedidoDecorator(PedidoBase componente) {
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

    public PedidoBase getComponente() {
        return componente;
    }
}
