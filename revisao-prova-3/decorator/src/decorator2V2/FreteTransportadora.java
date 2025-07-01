package decorator2V2;

public class FreteTransportadora extends PedidoDecorator{

    public FreteTransportadora(PedidoBase componente) {
        super(componente);
    }

    @Override
    public void concluir() {
        System.out.println("Comunicando com a transportadora");
    }

    @Override
    public double getTotal() {
        return super.getTotal() + 30;
    }
}
