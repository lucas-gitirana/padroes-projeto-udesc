package controller;

public interface Observador {
	public void embaralhar();
	public void virarPrimeiraCarta(int r, int c);
	public void notificarVitoria();
	public void notificarMatch(int r, int c);
}
