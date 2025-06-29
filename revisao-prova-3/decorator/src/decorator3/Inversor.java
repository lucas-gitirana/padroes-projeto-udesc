package decorator3;

public class Inversor extends TextoDecorator {

    public Inversor(Texto texto) {
        super(texto);
    }

    @Override
    public String getTexto() {
        String textoOriginal = super.getTexto();
        return new StringBuilder(textoOriginal).reverse().toString();
    }
}
