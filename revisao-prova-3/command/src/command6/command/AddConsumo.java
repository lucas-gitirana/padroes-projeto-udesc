package command6.command;

import command6.Cliente;
import command6.Command;
import command6.Hotel;
import command6.Produto;

import java.util.Date;

public class AddConsumo implements Command {

    private Hotel hotel;
    private Date date;
    private int quarto;
    private Produto produto;
    private int qtdade;

    public AddConsumo(Hotel hotel, Date date, int quarto, Produto produto, int qtdade) {
        this.hotel = hotel;
        this.date = date;
        this.quarto = quarto;
        this.produto = produto;
        this.qtdade = qtdade;
    }

    @Override
    public void execute() {
        hotel.addConsumo(date, quarto, produto, qtdade);
    }

    @Override
    public void undo() {

    }
}
