package decorator2;

public class FreteTransportadora extends PedidoDecorador {

    public FreteTransportadora(PedidoBase componente) {
        super(componente);
    }

    @Override
    public void concluir() {
        super.concluir();
        System.out.println("Comunicando com a transportadora");
    }

    @Override
    public double getTotal() {
        return super.getTotal() + 30;
    }
}
