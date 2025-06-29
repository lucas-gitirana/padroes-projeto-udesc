package decorator3;

public class Cripto extends TextoDecorator {

    public Cripto(Texto texto) {
        super(texto);
    }

    @Override
    public String getTexto() {
        String textoOriginal = super.getTexto();
        StringBuilder textoConvertido = new StringBuilder();

        for (int i = 0; i < textoOriginal.length(); i++) {
            char c = textoOriginal.charAt(i);
            char novoChar = (char) (c + 1);
            textoConvertido.append(novoChar);
        }

        return textoConvertido.toString();
    }
}
