package decorator2V2;

public class FreteCorreios extends PedidoDecorator {

    public FreteCorreios(PedidoBase componente) {
        super(componente);
    }

    @Override
    public void concluir() {
        super.concluir();
        System.out.println("Comunicando com os correios");
    }

    @Override
    public double getTotal() {
        return super.getTotal() + 40;
    }
}
