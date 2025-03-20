package observer4;

import java.util.ArrayList;
import java.util.List;

public class Revista {

	private String nome;
	private List<Edicao> edicoes = new ArrayList<Edicao>();
	private List<Observador> obss = new ArrayList<Observador>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void lancarNovaEdicao(Edicao e) {
		e.setRevista(this);
		this.edicoes.add(e);
		this.notificar(e);
	}
	
	public void anexar(Observador obs) {
		this.obss.add(obs);
	}
	
	private void notificar(Edicao e) {
		for (Observador obs : obss) {
			obs.receberLancamento(e);
		}
	}
	
}
