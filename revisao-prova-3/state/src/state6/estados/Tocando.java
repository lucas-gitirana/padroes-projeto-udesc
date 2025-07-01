package state6.estados;

import state6.PlayerMusica;

public class Tocando extends EstadoPlayerMusica {

    public Tocando(PlayerMusica playerMusica) {
        super(playerMusica);
    }

    @Override
    public void desligar() throws Exception {
        this.getPlayerMusica().setEstado(new Desligado(this.getPlayerMusica()));
    }

    @Override
    public void next() throws Exception {
        this.getPlayerMusica().getDisco().getFaixa().praFrente();
    }

    @Override
    public void prev() throws Exception {
        this.getPlayerMusica().getDisco().getFaixa().praTras();
    }

    @Override
    public void stop() throws Exception {
        this.getPlayerMusica().setEstado(new Parado(this.getPlayerMusica()));
    }

    @Override
    public void play() throws Exception {
        this.getPlayerMusica().getDisco().getFaixa().pause();
        this.getPlayerMusica().setEstado(new Pause(this.getPlayerMusica()));
    }

    @Override
    public String toString() {
        return "Tocando";
    }
}
