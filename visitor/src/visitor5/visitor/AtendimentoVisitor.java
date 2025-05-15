package visitor5.visitor;

import visitor5.taxi.Cliente;
import visitor5.taxi.Taxi;

public abstract class AtendimentoVisitor {

	public abstract void visitTaxi(Taxi taxi);
	
	private Cliente cliente;
	
	public AtendimentoVisitor(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
}
