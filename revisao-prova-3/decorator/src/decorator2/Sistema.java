package decorator2;

import decorator1.Arma;
import decorator1.ArmaBase;

public class Sistema {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(100);
        System.out.println(pedido.getTotal());
        pedido.concluir();

        PedidoDecorador freteCorreio = new FreteCorreio(pedido);
        System.out.println(freteCorreio.getTotal());
        freteCorreio.concluir();

        PedidoDecorador freteCorreioTransportadora = new FreteTransportadora(freteCorreio);
        System.out.println(freteCorreioTransportadora.getTotal());
        freteCorreioTransportadora.concluir();

        PedidoDecorador msgWhats = new MensagemWhatsapp(new FreteCorreio(freteCorreioTransportadora), "554552358");
        System.out.println(msgWhats.getTotal());
        msgWhats.concluir();

    }

}
