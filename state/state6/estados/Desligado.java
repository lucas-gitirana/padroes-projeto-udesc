package state6.estados;

import state6.PlayerMusica;

public class Desligado extends EstadoPlayerMusica {

	public Desligado(PlayerMusica playerMusica) {
		super(playerMusica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ligar() throws Exception {
		playerMusica.ligar();
	}

}
