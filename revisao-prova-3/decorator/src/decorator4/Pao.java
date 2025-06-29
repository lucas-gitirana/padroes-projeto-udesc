package decorator4;

public class Pao extends SanduicheDecorator {

    public Pao(Sanduiche componente) {
        super(componente);
    }

    @Override
    public double getPreco() {
        return super.getPreco() + 0.5;
    }

    @Override
    public String toString() {
        return "Pao " + super.toString();
    }
}
