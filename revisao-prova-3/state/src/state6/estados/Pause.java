package state6.estados;

import state6.PlayerMusica;

public class Pause extends EstadoPlayerMusica {

    public Pause(PlayerMusica playerMusica) {
        super(playerMusica);
    }

    @Override
    public void play() throws Exception {
        this.getPlayerMusica().getDisco().getFaixa().tocar();
        this.getPlayerMusica().setEstado(new Tocando(this.getPlayerMusica()));
    }

    @Override
    public void desligar() throws Exception {
        this.getPlayerMusica().setEstado(new Desligado(this.getPlayerMusica()));
    }

    @Override
    public void stop() throws Exception {
        this.getPlayerMusica().getDisco().getFaixa().parar();
        this.getPlayerMusica().setEstado(new Parado(this.getPlayerMusica()));
    }

    @Override
    public String toString() {
        return "Pause";
    }
}
