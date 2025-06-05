package state6.estados;

import state6.PlayerMusica;

public abstract class EstadoPlayerMusica {

	protected PlayerMusica playerMusica;

	public EstadoPlayerMusica(PlayerMusica playerMusica) {
		super();
		this.playerMusica = playerMusica;
	}
	
	public void ligar() throws Exception {
		throw new Exception("Nao pode ligar agora");
	}
	
	public void desligar() throws Exception {
		throw new Exception("Nao pode desligar agora");
	}
	
	public void stop() throws Exception {
		throw new Exception("Nao pode parar agora");
	}
	
	public void play() throws Exception {
		throw new Exception("Nao pode tocar agora");
	}
	
	public void next() throws Exception {
		throw new Exception("Nao pode avançar agora");
	}
	
	public void prev() throws Exception {
		throw new Exception("Nao pode retroceder agora");
	}
	
	public void proxEstado() {
		//TODO
	}
	
}
