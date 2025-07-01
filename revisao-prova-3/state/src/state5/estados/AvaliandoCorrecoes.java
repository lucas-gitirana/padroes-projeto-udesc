package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class AvaliandoCorrecoes extends EstadoArtigo {

    public AvaliandoCorrecoes(Artigo artigo) {
        super(artigo);
    }

    @Override
    public void proxEstado() {
        if (artigo.getMediaCorrecao() < artigo.getRevista().getNotaCortePublicacao() &&
            artigo.getQuantasCorrecoes() < artigo.getRevista().getQuantasCorrecoes()) {
            artigo.setEstado(new AguardandoCorrecoes(artigo));
        } else if (artigo.getMediaCorrecao() >= artigo.getRevista().getNotaCortePublicacao()) {
            artigo.setEstado(new AprovadoParaPublicacao(artigo));
        } else {
            artigo.setEstado(new Reprovado(artigo));
        }
    }
}
