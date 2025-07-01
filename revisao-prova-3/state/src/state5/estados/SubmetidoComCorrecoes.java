package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class SubmetidoComCorrecoes extends EstadoArtigo {

    public SubmetidoComCorrecoes(Artigo artigo) {
        super(artigo);
    }

    @Override
    public void correcoesRevisadas(int nota) throws Exception {
        artigo.addNotaCorrecaoRevisor(nota);
        artigo.setEstado(new RevisandoCorrecoes(artigo));
    }
}
