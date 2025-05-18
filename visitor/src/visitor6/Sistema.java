package visitor6;

import java.util.ArrayList;
import java.util.List;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;
import visitor6.visitor.VisitorCustoProjeto;
import visitor6.visitor.VisitorFimProjeto;
import visitor6.visitor.VisitorMontarEquipe;

public class Sistema {

	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public static void main(String[] args) throws Exception {
		
		funcionarios.add(new Funcionario("A", 1500, "Programador"));
		funcionarios.add(new Funcionario("B", 2500, "Analista"));
		funcionarios.add(new Funcionario("C", 3500, "Projetista"));
		funcionarios.add(new Funcionario("D", 5000, "Analista", "Programador"));
		funcionarios.add(new Funcionario("E", 5200, "Programador", "Analista"));
		funcionarios.add(new Funcionario("F", 8500, "Programador", "Projetista", "Analista"));
		funcionarios.add(new Funcionario("G", 8700, "Analista", "Programador", "Projetista"));
		funcionarios.add(new Funcionario("H", 8700, "Programador", "Projetista", "Analista"));
		funcionarios.add(new Funcionario("I", 1500, "Programador"));
		funcionarios.add(new Funcionario("J", 2500, "Analista"));
		funcionarios.add(new Funcionario("K", 3500, "Projetista"));		
		
		// nao pode mudar as linhas acima.... tudo o que for novo deve vir daqui para baixo
                // sugiro que crie metodos estaticos para atender os testes
		
		
		//Criando projetos
		Projeto pA = new Projeto("ProjetoA", 1, 0, 3);
		Projeto pB = new Projeto("ProjetoB", 1, 2, 2);
		Projeto pC = new Projeto("ProjetoC", 1, 3, 3);
		
		List<Projeto> projetos = new ArrayList<>();
		projetos.add(pA);
		projetos.add(pB);
		projetos.add(pC);
		
		
		VisitorMontarEquipe visitMontarEquipeA = new VisitorMontarEquipe(pA);
		VisitorCustoProjeto visitCustoProjetoA = new VisitorCustoProjeto(pA);
		VisitorFimProjeto visitFimProjetoA = new VisitorFimProjeto(pA);
		for (Funcionario f : funcionarios) {
			 //Montar equipe
			 f.accept(visitMontarEquipeA);
			 //Calcular custo
			 f.accept(visitCustoProjetoA);
			 //Finalizar projeto
			 f.accept(visitFimProjetoA);
		}
		
		VisitorMontarEquipe visitMontarEquipeB = new VisitorMontarEquipe(pB);
		VisitorCustoProjeto visitCustoProjetoB = new VisitorCustoProjeto(pB);
		VisitorFimProjeto visitFimProjetoB = new VisitorFimProjeto(pB);
		for (Funcionario f : funcionarios) {
			 //Montar equipe A
			 f.accept(visitMontarEquipeB);
			 //Calcular custo
			 f.accept(visitCustoProjetoB);
			 //Finalizar projeto
			 f.accept(visitFimProjetoB);
		}
		
		VisitorMontarEquipe visitMontarEquipeC = new VisitorMontarEquipe(pC);
		VisitorCustoProjeto visitCustoProjetoC = new VisitorCustoProjeto(pC);
		VisitorFimProjeto visitFimProjetoC = new VisitorFimProjeto(pC);
		for (Funcionario f : funcionarios) {
			 //Montar equipe A
			 f.accept(visitMontarEquipeC);
			 //Calcular custo
			 f.accept(visitCustoProjetoC);
			 //Finalizar projeto
			 f.accept(visitFimProjetoC);
		}		
		
		for (Projeto p : projetos) {
			String projetoTeste = p.getNome();
			System.out.println("=========== TESTE ===========");
			System.out.println("Funcionários " +projetoTeste+ ":");
			
			System.out.println("Analistas: ");
			for (Funcionario f : funcionarios) {
				if (f.getProjetoAtual() != null && f.getProjetoAtual().equals(projetoTeste) && f.getFuncoes().contains("Analista")) {
					System.out.println(f.toString());
				}
			}
			
			System.out.println("Projetistas: ");
			for (Funcionario f : funcionarios) {
				if (f.getProjetoAtual() != null && f.getProjetoAtual().equals(projetoTeste) && f.getFuncoes().contains("Projetista")) {
					System.out.println(f.toString());
				}
			}
			
			System.out.println("Programadores: ");
			for (Funcionario f : funcionarios) {
				if (f.getProjetoAtual() != null && f.getProjetoAtual().equals(projetoTeste) && f.getFuncoes().contains("Programador")) {
					System.out.println(f.toString());
				}
			}
		}
		
		System.out.println("=============== CUSTOS ===============");
		System.out.println("Custo do ProjetoA: " + visitCustoProjetoA.getTotalCusto());
		System.out.println("Custo do ProjetoB: " + visitCustoProjetoB.getTotalCusto());
		System.out.println("Custo do ProjetoC: " + visitCustoProjetoC.getTotalCusto());
		
	}

}
 