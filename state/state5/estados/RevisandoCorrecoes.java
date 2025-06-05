package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class RevisandoCorrecoes extends EstadoArtigo {

	public RevisandoCorrecoes(Artigo artigo) {
		super(artigo);
	}

	@Override
	public void correcoesRevisadas(int nota) throws Exception {
		artigo.addNotaCorrecaoRevisor(nota);
		artigo.setEstado(this);
	}

	@Override
	public void proxEstado() {
		if (artigo.getQuantasRevisoesCorrecao() == artigo.getRevista().getQtosRevisores()) {
			artigo.setEstado(new AvaliandoCorrecoes(artigo));
		}
	}
	

}
