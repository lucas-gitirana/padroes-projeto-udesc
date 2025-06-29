package state4.pedido;

public abstract class PedidoEstado {

    private Pedido pedido;

    public PedidoEstado(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void analisar() throws Exception  {
        throw new Exception("Não pode analisar");
    }

    public void suspender() throws Exception  {
        throw new Exception("Não pode suspender");
    }

    public void retomar() throws Exception  {
        throw new Exception("Não pode retomar");
    }

    public void cancelar() throws Exception  {
        throw new Exception("Não pode cancelar");
    }

    public void aprovar() throws Exception  {
        throw new Exception("Não pode aprovar");
    }

    public void atender() throws Exception  {
        throw new Exception("Não pode atender");
    }
}
