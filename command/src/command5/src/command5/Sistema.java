package command5;

import java.util.Scanner;

import command5.command.AdicionarMusica;
import command5.command.CommandInvoker;
import command5.command.ListarCarrinho;
import command5.command.PrecoTotal;
import command5.command.TamanhoMusicas;
import command5.observer.Observer;
import command5.sistema.ConsoleObserver;

public class Sistema{

	public static void main(String[] args) {
		Musica m1 = new Musica("AAahhhh", 15430, 15, 13.2f);
		Musica m2 = new Musica("Vai moleque", 22311, 72, 13.2f);
		Musica m3 = new Musica("Louca da caixa d'agua", 35723, 84, 13.2f);
		
		BancoMusicas.getInstancia().add(m1);
		BancoMusicas.getInstancia().add(m2);
		BancoMusicas.getInstancia().add(m3);
		
		CarrinhoCompras cc = new CarrinhoCompras();

		Scanner sc = new Scanner(System.in);
		
		//Command invoker
		CommandInvoker ci = new CommandInvoker();
		ConsoleObserver obs = new ConsoleObserver();
		
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

			    		//Musica m = BancoMusicas.getInstancia().getMusicas().get(opMusica);			    		
			    		//cc.add(m);
			    		
			    		ci.add(new AdicionarMusica(cc, obs, opMusica));
			    		ci.execute();
			    		break;
			    		
			    case 2:	// listar carrinho 
			    		//for (Musica mus:cc.getProdutos()) {
			    		//	System.out.println("> " + mus);
			    		//}
			    	
			    		ci.add(new ListarCarrinho(cc, obs));
			    		ci.execute();
			    		break;
			    		
			    case 3: // tamanho das musicas
//			    		int tamTotal = 0;
//			    		for (Musica mus:cc.getProdutos()) {
//			    			tamTotal += mus.getTamanho();
//			    		}
//			    		System.out.println("> " + tamTotal + " MB");
			    	
			    		ci.add(new TamanhoMusicas(cc, obs));
			    		ci.execute();
			    		break;
			    		
			    case 4: // preco total
//			    		float precoTotal = 0;
//			    		for (Musica mus:cc.getProdutos()) {
//			    			precoTotal += mus.getPreco();
//			    		}
//			    		System.out.println("> R$ " + precoTotal);
			    	
			    		ci.add(new PrecoTotal(cc, obs));
			    		ci.execute();
			    		break;
			    		
			    case 5: // undo
			    	ci.undo();
			    	break;
			    	
			    case 6: // redo
			    	ci.redo();
			    	break;
			    	
			}
		}
	}

}
