package abstractfactory4.abstractfactory;

public abstract class Personagem {

	private int populacao;
	private double recurso;
	
	public abstract double produzirRecurso();
	
	public void addPopulacao() {
		populacao++;
	}

	public int getPopulacao() {
		return populacao;
	}

	public double getRecurso() {
		return recurso;
	}

	public void setRecurso(double recurso) {
		this.recurso = recurso;
	}
	
}
