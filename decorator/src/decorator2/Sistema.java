package decorator2;

public class Sistema {

	public static void main(String[] args) {
		PedidoBase pedido = new Pedido(100);
		
		PedidoBase frete = new Frete(pedido, 0);
		frete.concluir();
		System.out.println(frete.getTotal());
		
		PedidoBase msgWhats = new MensagemWhatsapp(frete, "99 8890-0987");
		msgWhats.concluir();
	}

}
