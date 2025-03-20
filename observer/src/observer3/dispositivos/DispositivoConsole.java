package observer3.dispositivos;

import javax.swing.JLabel;

public class DispositivoConsole implements Observador {

	@Override
	public void receberMensagem(double temp, double umidade) {
		System.out.println("Temperatura: " + temp);
		System.out.println("Umidade: " + umidade);
	}
	
}
