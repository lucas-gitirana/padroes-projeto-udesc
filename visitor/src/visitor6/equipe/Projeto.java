package visitor6.equipe;

public class Projeto {

	private String nome;
	private int analistas;
	private int projetistas;
	private int programadores;
	
	public Projeto(String nome, int analistas, int projetistas, int programadores) {
		super();
		this.nome = nome;
		this.analistas = analistas;
		this.projetistas = projetistas;
		this.programadores = programadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnalistas() {
		return analistas;
	}

	public void setAnalistas(int analistas) {
		this.analistas = analistas;
	}

	public int getProjetistas() {
		return projetistas;
	}

	public void setProjetistas(int projetistas) {
		this.projetistas = projetistas;
	}

	public int getProgramadores() {
		return programadores;
	}

	public void setProgramadores(int programadores) {
		this.programadores = programadores;
	}

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", analistas=" + analistas + ", projetistas=" + projetistas
				+ ", programadores=" + programadores + "]";
	}
	
}
