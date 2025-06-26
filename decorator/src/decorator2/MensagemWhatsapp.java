package decorator2;

public class MensagemWhatsapp extends PedidoDecorator {

	private String numero;

	public MensagemWhatsapp(PedidoBase componente, String numero) {
		super(componente);
		this.numero = numero;
	}

	@Override
	public void concluir() {
		super.concluir();
		System.out.println("Comunicando com " +numero+ ". Preço do pedido: " + this.getComponente().getTotal());
	}

}
