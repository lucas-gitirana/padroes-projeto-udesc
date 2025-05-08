package visitor3;
import visitor3.empresa.FuncNivelA;
import visitor3.empresa.FuncNivelB;
import visitor3.empresa.Gerente;
import visitor3.empresa.Setor;
import visitor3.visitor.CalcFerias;
import visitor3.visitor.CalcFolhaPagamento;

public class Sistema {

	public static void main(String[] args) throws Exception {

		FuncNivelA f1 = new FuncNivelA("J", 5000);
		FuncNivelA f2 = new FuncNivelA("K", 4500);
		
		FuncNivelB f3 = new FuncNivelB("X", 1200);
		FuncNivelB f4 = new FuncNivelB("Y", 1500);
		
		Gerente g = new Gerente("AAA", 8000);
		
		Setor s = new Setor();
		s.add(f1);
		s.add(f2);
		s.add(f3);
		s.add(f4);
		s.add(g);
		
		s.setGerente(g);
		
		//Realizando accepts
		CalcFolhaPagamento calcFolha = new CalcFolhaPagamento();
		s.accept(calcFolha);
		System.out.println("Folha de Pagamento: " + calcFolha.getTotalFolha());
		
		CalcFerias calcFerias = new CalcFerias();
		s.accept(calcFerias);
		System.out.println("Total de funcionários que tiraram férias: " + calcFerias.getTotal());
		
		System.out.println(f1.getFeriasAGozar());
		System.out.println(f2.getFeriasAGozar());
		System.out.println(f3.getFeriasAGozar());
		System.out.println(f4.getFeriasAGozar());
		System.out.println(g.getFeriasAGozar());
	}

}
