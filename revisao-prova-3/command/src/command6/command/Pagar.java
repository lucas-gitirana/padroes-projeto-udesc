package command6.command;

import command6.Cliente;
import command6.Command;
import command6.Hotel;

public class Pagar implements Command {

    private Hotel hotel;
    private int quarto;
    private Cliente cliente;
    private double total;

    public Pagar(Hotel hotel, int quarto, Cliente cliente, double total) {
        this.hotel = hotel;
        this.quarto = quarto;
        this.cliente = cliente;
        this.total = total;
    }

    @Override
    public void execute() {
        hotel.pagar(quarto, cliente, total);
    }

    @Override
    public void undo() {

    }
}
