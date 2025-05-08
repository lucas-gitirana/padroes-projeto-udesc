package visitor4.personagens;

import visitor4.visitor.AtaqueVisitor;

public abstract class Personagem {

	private int pontoVida;
	private int forcaAtaque;
	
	public Personagem(int pontoVida, int forcaAtaque) {
		this.pontoVida = pontoVida;
		this.forcaAtaque = forcaAtaque;
	}
	
	public abstract void accept(AtaqueVisitor visitor) throws Exception;

	public int getPontoVida() {
		return pontoVida;
	}

	public void setPontoVida(int pontoVida) {
		this.pontoVida = pontoVida;
	}
	
	public int getForcaAtaque() {
		return forcaAtaque;
	}
	
	
	
}
