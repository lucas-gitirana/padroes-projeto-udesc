package state6.estados;

import state6.PlayerMusica;

public class Parado extends EstadoPlayerMusica {

    public Parado(PlayerMusica playerMusica) {
        super(playerMusica);
    }

    @Override
    public void next() throws Exception {
        this.getPlayerMusica().getDisco().proxFaixa();
    }

    @Override
    public void prev() throws Exception {
        this.getPlayerMusica().getDisco().voltarFaixa();
    }

    @Override
    public void desligar() throws Exception {
        this.getPlayerMusica().setEstado(new Desligado(this.getPlayerMusica()));
    }

    @Override
    public void play() throws Exception {
        this.getPlayerMusica().getDisco().getFaixa().tocar();
        this.getPlayerMusica().setEstado(new Tocando(this.getPlayerMusica()));
    }

    @Override
    public String toString() {
        return "Parado";
    }
}
