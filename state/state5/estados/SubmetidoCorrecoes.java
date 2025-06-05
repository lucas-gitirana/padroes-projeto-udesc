package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class SubmetidoCorrecoes extends EstadoArtigo {

	public SubmetidoCorrecoes(Artigo artigo) {
		super(artigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void correcoesRevisadas(int nota) throws Exception {
		artigo.addNotaCorrecaoRevisor(nota);
		artigo.setEstado(new RevisandoCorrecoes(artigo));
	}
	
	

}
