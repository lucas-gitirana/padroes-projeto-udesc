package decorator5;

import java.util.Random;

public class OrcDecorator implements Orc {

    private Orc componente;

    public OrcDecorator(Orc componente) {
        this.componente = componente;
    }

    @Override
    public int getSaude() {
        return componente.getSaude();
    }

    @Override
    public void setSaude(int saude) {
        componente.setSaude(saude);
    }

    @Override
    public int atacar() {
        return componente.atacar();
    }

    @Override
    public void defender(int ataque) {
        componente.defender(ataque);
    }
}
