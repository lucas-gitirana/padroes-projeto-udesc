package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class AceitoPublicacao extends EstadoArtigo {

	public AceitoPublicacao(Artigo artigo) {
		super(artigo);
	}

	@Override
	public void proxEstado() {
		if (artigo.getMediaRevisao() < artigo.getRevista().getNotaCortePublicacao()) {
			artigo.resetNotasCorrecoes();
			artigo.setEstado(new AguardandoCorrecoes(artigo));
			return;
		}
		
		artigo.setEstado(new AprovadoPublicacao(artigo));
	}

}
