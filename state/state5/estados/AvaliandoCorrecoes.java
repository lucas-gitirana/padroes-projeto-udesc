package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class AvaliandoCorrecoes extends EstadoArtigo {

	public AvaliandoCorrecoes(Artigo artigo) {
		super(artigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void proxEstado() {
		if (artigo.getMediaCorrecao() >= artigo.getRevista().getNotaCortePublicacao()) {
			artigo.setEstado(new AprovadoPublicacao(artigo));
			return;
		}
		
		if (artigo.getQuantasCorrecoes() < artigo.getRevista().getQuantasCorrecoes()) {
			artigo.resetNotasCorrecoes();
			artigo.setEstado(new AguardandoCorrecoes(artigo));
			return;
		}
		
		artigo.setEstado(new Reprovado(artigo));
	}	

}
