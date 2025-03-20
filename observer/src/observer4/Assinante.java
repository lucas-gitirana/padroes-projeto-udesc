package observer4;

public class Assinante implements Observador {
	private String nome;
	private String endereco;
	
	public Assinante(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void receberLancamento(Edicao e) {
		System.out.println("=============NOTIFICA��O ASSINANTE================");
		System.out.println("Assinante: " + nome);
		System.out.println("Revista: " + e.getRevista().getNome());
		System.out.println("Edi��o: " + e.getNumero());
	}
}
