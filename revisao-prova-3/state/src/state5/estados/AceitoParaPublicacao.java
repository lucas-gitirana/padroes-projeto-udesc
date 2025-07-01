package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class AceitoParaPublicacao extends EstadoArtigo {

    public AceitoParaPublicacao(Artigo artigo) {
        super(artigo);
    }

    @Override
    public void proxEstado() {
        if (artigo.getMediaRevisao() < artigo.getRevista().getNotaCortePublicacao()) {
            artigo.setEstado(new AguardandoCorrecoes(artigo));
        }
    }
}
