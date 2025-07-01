

public class PlayerMusica {

	private int tocando; // 0-stop 1-tocando 2-pause
	private Disco disco;
	private boolean ligado;

	public PlayerMusica(Disco disco) {
		this.disco = disco;

		this.tocando = 0;
	}
	
	public void play()  {
		if (!ligado)
			return;
		
		if (tocando == 0 || tocando == 2) {
			tocando = 1;
			disco.getFaixa().tocar();
		} else {
			if (tocando == 1) {
				tocando = 2;
				disco.getFaixa().pause();
			}
		}
	}
	
	public void stop()  {
		if (!ligado)
			return ;
		
		if (tocando > 0) {
			tocando = 0;
			disco.getFaixa().parar();
		}
	}
	
	public void next() {
		if (!ligado)
			return;
		
		if (tocando == 1)
			disco.getFaixa().praFrente();
		else
			if (tocando == 0)
				disco.proxFaixa();
			
	}
	
	public void prev() {
		if (!ligado)
			return;
		
		if (tocando == 1)
			disco.getFaixa().praTras();
		else
			if (tocando == 0)
				disco.voltarFaixa();
			
		
	}
	
	public void ligar() {
		if (!ligado) {
			ligado = true;
			tocando = 0;
		} 
	}
	
	public void desligar() {
		
		if (ligado)
			ligado = false;
		
		
	}

	public String getStatus() {
		return (!ligado?"Desligado":(tocando == 0?"Parado ":((tocando == 1?"Tocando ":"Pause ")) + disco.getFaixa()));
	}
	
}
