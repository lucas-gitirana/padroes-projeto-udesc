package decorator2V2;

public class MensagemWhatsapp extends PedidoDecorator {

    private String phone;

    public MensagemWhatsapp(PedidoBase componente, String phone) {
        super(componente);
        this.phone = phone;
    }

    @Override
    public void concluir() {
        System.out.println("Comunicando com o número " +phone+ ". Preço do pedido: " + getComponente().getTotal());
    }
}
