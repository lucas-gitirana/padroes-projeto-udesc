package command5;

import command5.command.*;

import java.io.Console;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		Musica m1 = new Musica("AAahhhh", 15430, 15, 13.2f);
		Musica m2 = new Musica("Vai moleque", 22311, 72, 13.2f);
		Musica m3 = new Musica("Louca da caixa d'agua", 35723, 84, 13.2f);
		
		BancoMusicas.getInstancia().add(m1);
		BancoMusicas.getInstancia().add(m2);
		BancoMusicas.getInstancia().add(m3);

		CommandInvoker invoker = new CommandInvoker();
		ConsoleObserver observer = new ConsoleObserver();
		CarrinhoCompras cc = new CarrinhoCompras();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Menu");
			System.out.println("1-Adicionar no carrinho");
			System.out.println("2-Listar carrinho");
			System.out.println("3-Tamanho das m\u00FAsicas");
			System.out.println("4-Pre\u00E7o total");
			System.out.println("5-Undo");
			System.out.println("6-Redo");

			int op = sc.nextInt();
			switch (op) {
			    case 1: // adicionar no carrinho
			    		System.out.println("Escolha a m\u00FAsica (1 a 3)");
			    		int opMusica = sc.nextInt() - 1;
						invoker.execute(new AddMusica(cc, opMusica, observer));
			    		break;
			    		
			    case 2:	// listar carrinho
						invoker.execute(new ListarCarrinho(cc, observer));
			    		break;
			    		
			    case 3: // tamanho das musicas
						invoker.execute(new TamanhoMusicas(cc, observer));
						break;
			    		
			    case 4: // preco total
						invoker.execute(new PrecoTotal(cc, observer));
			    		break;
				case 5:
					invoker.undo();
					break;
				case 6:
					invoker.redo();
					break;
			}
		}
	}

}
