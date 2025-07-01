package state6.estados;

import state6.PlayerMusica;

public class Desligado extends EstadoPlayerMusica {

    public Desligado(PlayerMusica playerMusica) {
        super(playerMusica);
    }

    @Override
    public void ligar() throws Exception {
        this.getPlayerMusica().setEstado(new Parado(this.getPlayerMusica()));
    }

    @Override
    public String toString() {
        return "Desligado";
    }
}
