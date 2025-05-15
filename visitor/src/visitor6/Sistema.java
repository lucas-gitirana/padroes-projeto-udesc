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
		
		for (Funcionario f : funcionarios) {
			 for (Projeto p : projetos) {
				 VisitorMontarEquipe visitMontarEquipe = new VisitorMontarEquipe(p);
				 f.accept(visitMontarEquipe);
				 
				 VisitorCustoProjeto visitCustoProjeto = new VisitorCustoProjeto(p);
				 f.accept(visitCustoProjeto);
				 
				 VisitorFimProjeto visitFimProjeto = new VisitorFimProjeto(p);
				 f.accept(visitFimProjeto);
			 }
		}
		
	}

}
 