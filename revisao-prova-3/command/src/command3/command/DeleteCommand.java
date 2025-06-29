package command3.command;

import command3.dao.BancoPessoas;
import command3.modelo.Pessoa;
import command3.observer.Observer;

public class DeleteCommand extends Command {

    private String[] dados;
    private Pessoa pessoa;

    public DeleteCommand(Observer observer, String[] dados) {
        super(observer);
        this.dados = dados;
    }

    @Override
    public void execute() {
        int id = Integer.parseInt(dados[0]);
        this.pessoa = BancoPessoas.getInstance().removerPessoa(id);

        String[][] res = new String[1][2];
        res[0][0] = String.valueOf(id);
        res[0][1] = pessoa.getNome();
        observer.removeuPessoa(res);
    }

    @Override
    public void undo() {
        BancoPessoas.getInstance().addPessoa(this.pessoa.getId(), this.pessoa.getNome());
    }

    @Override
    public void redo() {
        execute();
    }
}
