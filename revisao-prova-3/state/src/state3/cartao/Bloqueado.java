package state3.cartao;

public class Bloqueado extends CartaoEstado {

    public Bloqueado(Cartao cartao) {
        super(cartao);
    }

    @Override
    public void entrarPin(String pin) throws Exception {
        throw new Exception("Não pode entrar PIN. CARTÃO BLOQUEADO");
    }

    @Override
    public void fazerPagamento() throws Exception {
        throw new Exception("Não pode fazer pagamento. CARTÃO BLOQUEADO");
    }

    @Override
    public void proxEstado() throws Exception {
        throw new Exception("Não pode mudar de estado");
    }
}
