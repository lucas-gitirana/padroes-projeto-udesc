package decorator5;

public class OrcJoiaVida extends OrcDecorator {

    public OrcJoiaVida(Orc componente) {
        super(componente);
    }

    @Override
    public int getSaude() {
        return super.getSaude() + (int) (super.getSaude() * 0.2);
    }
}
