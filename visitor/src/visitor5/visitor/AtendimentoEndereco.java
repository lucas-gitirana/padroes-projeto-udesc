package visitor5.visitor;

import visitor5.taxi.Cliente;
import visitor5.taxi.Taxi;

public class AtendimentoEndereco extends AtendimentoVisitor {

	public AtendimentoEndereco(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void visitTaxi(Taxi taxi) {
		if (!taxi.isOcupado() && taxi.getPontoTaxi() == getCliente().getPontoProximo()) {
			taxi.atender(getCliente());
		}
	}

}
