package controle;

import java.util.ArrayList;
import java.util.List;

import model.Deposito;

public class DepositoController {

	private List<Observer> obss = new ArrayList<>();
	private Deposito deposito;
	
	
	public void addObserver(Observer obs) {
		this.obss.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		this.obss.remove(obs);
	}
	
	public int getQuantidadeAtual() {
		return deposito.getQtdAtual();
	}
	
	public void criarDeposito(int qtdCritica, int qtdMaxima) {
		this.deposito = new Deposito(qtdCritica, qtdMaxima);
		notificaCriacao();
	}

	public void addQuantidade(int qtd) {
		try {
			this.deposito.add(qtd);
			notificaAdd(qtd);
		} catch (Exception e) {
			notificaErro(e.getMessage());
		}
	}
	
	public void removeQuantidade(int qtd) {
		notificaRemove(this.deposito.retirar(qtd));
	}

	public void notificaCriacao() {
		for (Observer obs : obss) {
			obs.criouDeposito();
		}
	}
	
	private void notificaErro(String message) {
		for (Observer obs : obss) {
			obs.erro(message);
		}
	}
	
	private void notificaAdd(int qtdAdicionada) {
		for (Observer obs : obss) {
			obs.adicionouQuantidade(qtdAdicionada);
		}
	}
	
	private void notificaRemove(int qtdRemovida) {
		for (Observer obs : obss) {
			obs.removeuQuantidade(qtdRemovida);
		}
	}
	
}
