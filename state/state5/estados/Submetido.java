package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class Submetido extends EstadoArtigo {

	public Submetido(Artigo artigo) {
		super(artigo);
		
	}

	@Override
	public void revisao(int nota) throws Exception {
		artigo.addNotaRevisor(nota);
		artigo.setEstado(new Revisando(artigo));
	}
	
	

}
