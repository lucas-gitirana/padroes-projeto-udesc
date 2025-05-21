package control;

public interface Observer {

	void virouACarta(int r, int c, int numero);

	void virouAPrimeiraCarta(int r, int c);

	void venceuJogo(int r, int c, int numero);

	void encontrouPar(int r, int c, int numero);

	void paresDiferentes(int holdCardRow, int holdCardColumn, int r, int c);

}
