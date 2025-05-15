package visitor5.taxi;

import java.util.ArrayList;
import java.util.List;
import visitor5.visitor.AtendimentoVisitor;

public class CentralAtendimento {

	private List<Taxi> taxis = new ArrayList<>();
	
	public void addTaxi(Taxi t) {
		this.taxis.add(t);
	}
	
	public void accept (AtendimentoVisitor visitor) throws Exception {
		for (Taxi t : taxis) {
			if (!t.isOcupado()) {
				t.accept(visitor);
				if (t.isOcupado()) return; 
			}
		}
		
		System.out.println("Atendimento ligou para cliente " + visitor.getCliente().getNumeroTelefone() + " avisando que nao tem taxi");
	}
	
}
