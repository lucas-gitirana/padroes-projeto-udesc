package decorator5;

public class Sistema {

    public static void main(String[] args) {
        OrcBasico basico1 = new OrcBasico();
        System.out.println(basico1.getSaude());

        OrcBasico basico2 = new OrcBasico();
        System.out.println(basico2.getSaude());

        Orc poderoso = new OrcJoiaVida(new OrcEscudo(new OrcMachado(basico2)));
        basico1.defender(poderoso.atacar());
        poderoso.defender(basico1.atacar());
        System.out.println(basico1.getSaude());
        System.out.println(poderoso.getSaude());
    }

}
