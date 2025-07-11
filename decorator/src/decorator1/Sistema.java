package decorator1;

public class Sistema {

	public static void main(String[] args) {
		ArmaBase pistola = new Arma();
		pistola.atirarComCalma();
		
		/*COMENTÁRIOS DE AULA*/
		ArmaBase metralhadora = new Repeticao(pistola);
		metralhadora.atirarComCalma();
		
		ArmaBase met2 = new Repeticao(new Arma());
		metralhadora.atirarComCalma();
		
		ArmaBase pistolaCoMira = new MiraTelescopica(pistola);
		pistolaCoMira.atirarComCalma();
		
		ArmaBase pistolaCoMira2 = new MiraTelescopica(metralhadora);
		pistolaCoMira2.atirarComCalma();
		
		/*
		ArmaBase pistolaExplosiva = new BalaExplosiva(pistola);
		pistolaExplosiva.atirarComCalma();
		
		//ArmaBase pistolaFerrou = new MiraTelescopica(new BalaExplosiva(pistola));
		ArmaBase pistolaFerrou = new BalaExplosiva(new MiraTelescopica(pistola)); // mesmo efeito
		pistolaFerrou.atirarComCalma();
		
		ArmaBase metralhadora = new Repeticao(new MiraTelescopica(new BalaExplosiva(pistola)));
		metralhadora.atirarComCalma();
		
		System.out.println("--");
		
		ArmaBase superMetralhadora = new Repeticao(new Repeticao(new MiraTelescopica(new BalaExplosiva(pistola))));
		superMetralhadora.atirarComCalma();
		*/
	}

}
