package visitor5.main;

import java.util.ArrayList;
import java.util.List;

import visitor5.taxi.CentralAtendimento;
import visitor5.taxi.Cliente;
import visitor5.taxi.Taxi;
import visitor5.visitor.AtendimentoEndereco;
import visitor5.visitor.AtendimentoVisitor;

public class Sistema {

	public static void main(String[] args) throws Exception {
		
		//Criando frota de táxis
		Taxi t0 = new Taxi(100, 1);
		Taxi t1 = new Taxi(101, 2);
		Taxi t2 = new Taxi(102, 2);
		Taxi t3 = new Taxi(103, 1);
		Taxi t4 = new Taxi(104, 3);
		
		CentralAtendimento central = new CentralAtendimento();
		central.addTaxi(t0);
		central.addTaxi(t1);
		central.addTaxi(t2);
		central.addTaxi(t3);
		central.addTaxi(t4);
		
		//Atendendo clientes
		Cliente c1 = new Cliente(1, "91234");
		Cliente c2 = new Cliente(2, "95678");
		Cliente c3 = new Cliente(4, "90000");
		Cliente c4 = new Cliente(1, "92468");
		Cliente c5 = new Cliente(1, "90001");
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
		clientes.add(c5);
		
		for (Cliente c : clientes) {
			AtendimentoVisitor visitor = new AtendimentoEndereco(c);
			central.accept(visitor);
		}
	}

}
