package controle;

public interface Observer {

	public void criouDeposito();
	public void adicionouQuantidade(int qtd);
	public void removeuQuantidade(int qtd);
	public void erro(String message);
}
