package decorator2V2;


public class SistemaV2 {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(100);
        System.out.println(pedido.getTotal());
        pedido.concluir();

        PedidoDecorator freteCorreio = new FreteCorreios(pedido);
        System.out.println(freteCorreio.getTotal());
        freteCorreio.concluir();

        PedidoDecorator freteCorreioTransportadora = new FreteTransportadora(freteCorreio);
        System.out.println(freteCorreioTransportadora.getTotal());
        freteCorreioTransportadora.concluir();

        PedidoDecorator msgWhats = new MensagemWhatsapp(new FreteCorreios(freteCorreioTransportadora), "554552358");
        System.out.println(msgWhats.getTotal());
        msgWhats.concluir();
    }
}
