package command6;

import command6.command.*;
import command6.observer.Observer;
import command6.observer.SistemaObserver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sistema{

	public static void main(String[] args) throws Exception {

		Cliente cliente = buscarCliente(1);
		Date date = converterData("17/05/2022");
		
		Hotel hotel = new Hotel();

		CommandInvoker invoker = new CommandInvoker();
		SistemaObserver observer = new SistemaObserver();

		//hotel.reservar(date, 10, cliente);
		invoker.execute(new Reservar(hotel, date, 10, cliente));

		//hotel.cancelarReserva(date, 10, cliente);
		invoker.execute(new Cancelar(hotel, date, 10, cliente));
		
		//hotel.reservar(date, 15, cliente);
		invoker.execute(new Reservar(hotel, date, 15, cliente));
		
		//hotel.checkIn(date, 15, cliente);
		invoker.execute(new CheckIn(hotel, date, 15, cliente));

		//hotel.addConsumo(date, 15, buscarProduto(30), 3);
		invoker.execute(new AddConsumo(hotel, date, 15, buscarProduto(30), 3));

		//hotel.addConsumo(date, 15, buscarProduto(50), 10);
		invoker.execute(new AddConsumo(hotel, date, 15, buscarProduto(50), 10));

		//double total = hotel.checkOut(date, 10, cliente);
		invoker.execute(new Checkout(hotel, date, 10, cliente, observer));
		double total = observer.getTotal();

		hotel.pagar(10, cliente, total);
		invoker.execute(new Pagar(hotel, 10, cliente, total));
		
	}

	private static Produto buscarProduto(int i) {
		// metodo fake
		return new Produto();
	}

	private static Date converterData(String dataS) throws ParseException {
		return sdf.parse(dataS);
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private static Cliente buscarCliente(int i) {
		// metodo fake
		return new Cliente();
	}
}
