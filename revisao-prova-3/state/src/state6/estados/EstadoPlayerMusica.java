package state6.estados;

import state6.PlayerMusica;

public abstract class EstadoPlayerMusica {

    private PlayerMusica playerMusica;

    public EstadoPlayerMusica(PlayerMusica playerMusica) {
        this.playerMusica = playerMusica;
    }

    public PlayerMusica getPlayerMusica() {
        return playerMusica;
    }

    public void ligar() throws Exception {
    }

    public void desligar() throws Exception {
    }

    public void stop() throws Exception {
    }

    public void next() throws Exception {
    }

    public void prev() throws Exception {
    }

    public void play() throws Exception {
    }
}
