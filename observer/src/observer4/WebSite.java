package observer4;

public class WebSite implements Observador {
	private String url;
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void receberLancamento(Edicao e) {
		System.out.println("=============NOTIFICA��O WEBSITE================");
		System.out.println("Revista: " + e.getRevista().getNome());
		System.out.println("N�mero da edi��o: " + e.getNumero());
		
		for (Artigo a : e.getArtigos() ) {
			System.out.println("--> Artigo: " + a.getTitulo());
		}
		
	}
}
