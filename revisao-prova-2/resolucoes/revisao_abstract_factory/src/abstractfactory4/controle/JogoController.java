package abstractfactory4.controle;

import java.util.ArrayList;
import java.util.List;

public class JogoController {

	private List<Observer> obss;
	private int limite;

	public JogoController() {
		this.obss = new ArrayList<Observer>();
		this.limite = 0;
	}
	
	public void addObserver(Observer o) {
		this.obss.add(o);
	}
	
	
	
}
