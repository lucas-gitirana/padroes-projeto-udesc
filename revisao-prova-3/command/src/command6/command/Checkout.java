package command6.command;

import command6.Cliente;
import command6.Command;
import command6.Hotel;
import command6.observer.Observer;

import java.util.Date;

public class Checkout implements Command {

    private Hotel hotel;
    private Date date;
    private int quarto;
    private Cliente cliente;
    private Observer observer;

    public Checkout(Hotel hotel, Date date, int quarto, Cliente cliente, Observer observer) {
        this.hotel = hotel;
        this.date = date;
        this.quarto = quarto;
        this.cliente = cliente;
        this.observer = observer;
    }

    @Override
    public void execute() {
        double total = hotel.checkOut(date, quarto, cliente);
        observer.realizouCheckout(total);
    }

    @Override
    public void undo() {

    }
}
