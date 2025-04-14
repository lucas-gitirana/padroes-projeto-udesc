package model;

public class Deposito {
	
	private int qtdAtual;
	private int qtdCritica;
	private int qtdMaxima;
	
	public Deposito(int qtdCritica, int qtdMaxima) {
		super();
		this.qtdCritica = qtdCritica;
		this.qtdMaxima = qtdMaxima;
	}
	
	public void add(int qtd) throws Exception {
		if (qtd + qtdAtual > qtdMaxima) {
			qtdAtual = qtdMaxima;
			throw new Exception("Tentativa de armazenar mais do que o permitido");
		}
		qtdAtual += qtd;
	}
	
	public int retirar(int qtd) {
		if (qtd <= qtdAtual) {
			qtdAtual -= qtd;
			return qtd;
		}
		
		int disponivel = qtdAtual; 
		qtdAtual = 0;
		return disponivel;
	}

	public int getQtdAtual() {
		return qtdAtual;
	}

	public void setQtdAtual(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}

	public int getQtdCritica() {
		return qtdCritica;
	}

	public void setQtdCritica(int qtdCritica) {
		this.qtdCritica = qtdCritica;
	}

	public int getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(int qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}
	
	

}
