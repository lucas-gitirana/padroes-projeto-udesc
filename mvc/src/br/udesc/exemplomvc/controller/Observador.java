package br.udesc.exemplomvc.controller;

public interface Observador {
	void salvouVeiculo();

	void excluiuVeiculo();

	void achouVeiculo(String modelo, String marca, int ano);

	void naoAchouVeiculo();
	
	void cancelou();
}
