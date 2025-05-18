package visitor6.visitor;

import visitor6.equipe.Funcionario;
import visitor6.equipe.Projeto;

public class VisitorMontarEquipe extends Visitor {

	private int contAnalistas;
	private int contProjetistas;
	private int contProgramadores;
	
	public VisitorMontarEquipe(Projeto projeto) {
		super(projeto);
		this.contAnalistas = 0;
		this.contProjetistas = 0;
		this.contProgramadores = 0;
	}

	@Override
	public void visitProjeto(Funcionario func) {
		if (func.getProjetoAtual() == null || func.getProjetoAtual().equalsIgnoreCase(getProjeto().getNome())) {
			for (String funcao : func.getFuncoes()) {
				
				//Atribuindo analista
				if (funcao == "Analista" && contAnalistas < getProjeto().getAnalistas()) {
					func.setProjetoAtual(getProjeto().getNome());
					contAnalistas++;
					
//					System.out.println("Adicionou o func. " +func.getNome()+ " como Analista no projeto " + getProjeto().getNome());
				}
				
				//Atribuindo projetista
				if (funcao == "Projetista" && contProjetistas < getProjeto().getProjetistas()) {
					func.setProjetoAtual(getProjeto().getNome());
					contProjetistas++;
					
//					System.out.println("Adicionou o func. " +func.getNome()+ " como Projetista no projeto " + getProjeto().getNome());
				}
				
				//Atribuindo programador
				if (funcao == "Programador" && contProgramadores < getProjeto().getProgramadores()) {
					func.setProjetoAtual(getProjeto().getNome());
					contProgramadores++;
					
//					System.out.println("Adicionou o func. " +func.getNome()+ " como Programador no projeto " + getProjeto().getNome());
				}
				
			}
		}
		
	}
	
	

}
