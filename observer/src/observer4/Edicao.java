package observer4;

import java.util.ArrayList;
import java.util.List;

public class Edicao {
	
	private int numero;
	private Revista revista;
	private List<Artigo> artigos = new ArrayList<Artigo>();
	
	public Edicao(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	
	public Revista getRevista() {
		return this.revista;
	}
	
	public List<Artigo> getArtigos() {
		return this.artigos;
	}
	
	public void addArtigo(Artigo a) {
		this.artigos.add(a);
	}

}
