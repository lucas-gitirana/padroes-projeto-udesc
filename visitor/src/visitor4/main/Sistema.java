package visitor4.main;

import visitor4.personagens.Arqueiro;
import visitor4.personagens.Catapulta;
import visitor4.personagens.Jogo;
import visitor4.personagens.Lanceiro;
import visitor4.visitor.AtaqueArqueiro;
import visitor4.visitor.AtaqueCatapulta;
import visitor4.visitor.AtaqueLanceiro;

public class Sistema {

	public static void main(String[] args) throws Exception {
		Arqueiro arqueiro = new Arqueiro();		
		Lanceiro lanceiro = new Lanceiro();
		Catapulta catapulta = new Catapulta();
		
		Jogo jogo = new Jogo();
		jogo.addPersonagem(arqueiro);
		jogo.addPersonagem(lanceiro);
		jogo.addPersonagem(catapulta);
		
		//Accepts
		AtaqueArqueiro ataqueArqueiro = new AtaqueArqueiro(arqueiro);
		jogo.accept(ataqueArqueiro);
		
		AtaqueLanceiro ataqueLanceiro = new AtaqueLanceiro(lanceiro);
		jogo.accept(ataqueLanceiro);
		
		AtaqueCatapulta ataqueCatapulta = new AtaqueCatapulta(catapulta);
		jogo.accept(ataqueCatapulta);
		
		System.out.println(arqueiro.getPontoVida());
		System.out.println(lanceiro.getPontoVida());
		System.out.println(catapulta.getPontoVida());
	}

}
