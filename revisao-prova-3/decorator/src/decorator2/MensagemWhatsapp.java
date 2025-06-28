package decorator2;

public class MensagemWhatsapp extends PedidoDecorador {

    private String numero;

    public MensagemWhatsapp(PedidoBase componente, String numero) {
        super(componente);
        this.numero = numero;
    }

    @Override
    public void concluir() {
        super.concluir();
        System.out.println("Comunicando com o número " +numero+ ". Preço do pedido: " + getComponente().getTotal());
    }
}
