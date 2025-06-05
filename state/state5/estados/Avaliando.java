package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class Avaliando extends EstadoArtigo {

	public Avaliando(Artigo artigo) {
		super(artigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void proxEstado() {
		if (artigo.getMediaRevisao() < artigo.getRevista().getNotaCorte()) {
			artigo.setEstado(new Reprovado(artigo));
			return;
		} 
		artigo.setEstado(new AceitoPublicacao(artigo));
	}

}
