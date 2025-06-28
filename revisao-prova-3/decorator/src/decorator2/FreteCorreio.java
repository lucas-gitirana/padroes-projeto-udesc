package decorator2;

public class FreteCorreio extends PedidoDecorador {

    public FreteCorreio(PedidoBase componente) {
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
