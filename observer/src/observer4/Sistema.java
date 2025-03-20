package observer4;

public class Sistema {

	public static void main(String[] args) {
		
		//Criamos 2 revistas
		Revista r1 = new Revista();
		r1.setNome("R1");
		Revista r2 = new Revista();
		r2.setNome("R2");
		
		//Criamos 5 assinantes
		Assinante a1 = new Assinante("A1");
		Assinante a2 = new Assinante("A2");
		Assinante a3 = new Assinante("A3");
		Assinante a4 = new Assinante("A4");
		Assinante a5 = new Assinante("A5");
		
		//Criamos 1 website
		WebSite ws = new WebSite();
		ws.setUrl("www.teste.com.br");
		
		//Registramos a1 e a3 + website na revista 1
		r1.anexar(a1);
		r1.anexar(a2);
		r1.anexar(a3);
		r1.anexar(ws);
		
		//Registramos a1 e a3 + website na revista 1
		r2.anexar(a2);
		r2.anexar(a4);
		r2.anexar(ws);
		
		//Artigos da R1
		Artigo t1 = new Artigo("T1");
		Artigo t2 = new Artigo("T2");
		Edicao e1 = new Edicao(1);
		e1.addArtigo(t1);
		e1.addArtigo(t2);
		r1.lancarNovaEdicao(e1);
		
		//Artigos da R2
		Artigo t3 = new Artigo("T3");
		Artigo t4 = new Artigo("T4");
		Artigo t5 = new Artigo("T5");
		Edicao e2 = new Edicao(2);
		e2.addArtigo(t3);
		e2.addArtigo(t4);
		e2.addArtigo(t5);
		r2.lancarNovaEdicao(e2);
	}

}
