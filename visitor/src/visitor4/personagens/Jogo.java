package visitor4.personagens;

import java.util.HashSet;
import java.util.Set;

import visitor4.visitor.AtaqueVisitor;


public class Jogo {

	private Set<Personagem> personagens = new HashSet<>();
	
	public void addPersonagem(Personagem p) {
		this.personagens.add(p);
	}
	
	public void accept (AtaqueVisitor visitor) throws Exception {
		for (Personagem p : personagens)
			p.accept(visitor);
	}
}
