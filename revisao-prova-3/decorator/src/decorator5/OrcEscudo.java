package decorator5;

import java.util.Random;

public class OrcEscudo extends OrcDecorator {

    public OrcEscudo(Orc componente) {
        super(componente);
    }

    @Override
    public void defender(int ataque) {
        super.defender(ataque);

        int porrada = ataque - 7;
        if (porrada > 0)
            setSaude(porrada);
    }
}
