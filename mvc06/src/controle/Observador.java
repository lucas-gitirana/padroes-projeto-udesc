package controle;

public interface Observador {
	public void venceuPedra(int choice_human, int choice_computer);
	public void venceuPapel(int choice_human, int choice_computer);
	public void venceuTesoura(int choice_human, int choice_computer);
	public void empate(int choice_human, int choice_computer);
}
