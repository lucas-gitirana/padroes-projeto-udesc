package command3.command;

import command3.dao.BancoPessoas;
import command3.modelo.Pessoa;
import command3.observer.Observer;

public class GetCommando extends Command{

    private String[] dados;

    public GetCommando(Observer observer, String[] dados) {
        super(observer);
        this.dados = dados;
    }

    @Override
    public void execute() {
        Pessoa pessoa = BancoPessoas.getInstance().getPessoa(Integer.parseInt(dados[0]));

        String[][] res = new String[1][2];
        res[0][0] = String.valueOf(pessoa.getId());
        res[0][1] = pessoa.getNome();
        this.observer.buscouPessoa(res);
    }

    @Override
    public void undo() {
        //
    }

    @Override
    public void redo() {
        //
    }
}
