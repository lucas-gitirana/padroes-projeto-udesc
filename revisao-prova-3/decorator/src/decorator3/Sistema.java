package decorator3;

public class Sistema {

	public static void main(String[] args) {

		Texto texto = new TextoSimples("Teste do Decorator");
		System.out.println(texto);
		
		Maiusculas maiusculas = new Maiusculas(texto);
		System.out.println(maiusculas);

		Sublinhador sublinhador = new Sublinhador(maiusculas);
		System.out.println(sublinhador);
		
		// Inversor: transforma o texto de tras para frente
		Inversor inversor = new Inversor(sublinhador);
		System.out.println(inversor);

		// Cripto: troca cada caracter pelo seu posterior, conforme tabela ASCII. Por exemplo, a vira b, b vira c e o z vira {
		Cripto cripto = new Cripto(inversor);
		System.out.println(cripto);
		
	}

}
