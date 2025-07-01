package state6;

import state6.estados.Desligado;
import state6.estados.EstadoPlayerMusica;

public class PlayerMusica {

	private int tocando; // 0-stop 1-tocando 2-pause
	private Disco disco;
	private boolean ligado;
	private EstadoPlayerMusica estado;

	public PlayerMusica(Disco disco) {
		this.disco = disco;
		this.tocando = 0;

		this.setEstado(new Desligado(this));
	}

	public EstadoPlayerMusica getEstado() {
		return estado;
	}

	public void setEstado(EstadoPlayerMusica estado) {
		this.estado = estado;
	}

	public int getTocando() {
		return tocando;
	}

	public void setTocando(int tocando) {
		this.tocando = tocando;
	}

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public void play()  {
//		if (!ligado)
//			return;
//
//		if (tocando == 0 || tocando == 2) {
//			tocando = 1;
//			disco.getFaixa().tocar();
//		} else {
//			if (tocando == 1) {
//				tocando = 2;
//				disco.getFaixa().pause();
//			}
//		}

        try {
            this.estado.play();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public void stop()  {
//		if (!ligado)
//			return ;
//
//		if (tocando > 0) {
//			tocando = 0;
//			disco.getFaixa().parar();
//		}

        try {
            this.estado.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public void next() {
//		if (!ligado)
//			return;
//
//		if (tocando == 1)
//			disco.getFaixa().praFrente();
//		else
//			if (tocando == 0)
//				disco.proxFaixa();

        try {
            this.estado.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
	
	public void prev() {
//		if (!ligado)
//			return;
//
//		if (tocando == 1)
//			disco.getFaixa().praTras();
//		else
//			if (tocando == 0)
//				disco.voltarFaixa();

        try {
            this.estado.prev();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public void ligar() {
//		if (!ligado) {
//			ligado = true;
//			tocando = 0;
//		}

        try {
            this.estado.ligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public void desligar() {
//		if (ligado)
//			ligado = false;

        try {
            this.estado.desligar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

	public String getStatus() {
//		return (!ligado?"Desligado":(tocando == 0?"Parado ":((tocando == 1?"Tocando ":"Pause ")) + disco.getFaixa()

		String estado = this.estado.toString();

		return estado + (
				estado.equalsIgnoreCase("Tocando") || estado.equalsIgnoreCase("Pause")
				? " " + disco.getFaixa() : "") ;
	}
	
}
