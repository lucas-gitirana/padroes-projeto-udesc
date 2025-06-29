package decorator4;

public abstract class SanduicheDecorator implements Sanduiche {

    private Sanduiche componente;

    public SanduicheDecorator(Sanduiche componente) {
        this.componente = componente;
    }

    @Override
    public double getPreco() {
        return componente.getPreco();
    }

    @Override
    public String toString() {
        return componente.toString();
    }
}
