package controle;

public interface Observer {
	public void acertou(int r, int c);
	public void errou(int r, int c, int holdCardRow, int holdCardColumn);
	public void venceu();
	public void bloqueiaCarta(int holdCardRow, int holdCardColumn);
}
