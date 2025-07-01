package decorator5;

import java.util.Random;

public class OrcMachado extends OrcDecorator {

    private static Random sorteio = new Random();

    public OrcMachado(Orc componente) {
        super(componente);
    }

    @Override
    public int atacar() {
        return super.atacar() + sorteio.nextInt(1, 5);
    }
}
