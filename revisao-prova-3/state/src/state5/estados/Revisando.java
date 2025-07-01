package state5.estados;

import state5.artigo.Artigo;
import state5.artigo.EstadoArtigo;

public class Revisando extends EstadoArtigo  {

    public Revisando(Artigo artigo) {
        super(artigo);
    }

    @Override
    public void revisao(int nota) throws Exception {
        artigo.addNotaRevisor(nota);
        proxEstado();
    }

    @Override
    public void proxEstado() {
        if (artigo.getQuantasRevisoes() == artigo.getRevista().getQtosRevisores()) {
            artigo.setEstado(new Avaliando(artigo));
        }
    }
}
