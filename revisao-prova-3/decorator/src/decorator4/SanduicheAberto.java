package decorator4;

public class SanduicheAberto implements Sanduiche{

    @Override
    public double getPreco() {
        return 3;
    }

    @Override
    public String toString() {
        return "(Tudo colocado no prato)";
    }
}
