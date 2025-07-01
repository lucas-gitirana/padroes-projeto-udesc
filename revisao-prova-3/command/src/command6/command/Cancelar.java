package command6.command;

import command6.Cliente;
import command6.Command;
import command6.Hotel;

import java.util.Date;

public class Cancelar implements Command {

    private Hotel hotel;
    private Date date;
    private int quarto;
    private Cliente cliente;

    public Cancelar(Hotel hotel, Date date, int quarto, Cliente cliente) {
        this.hotel = hotel;
        this.date = date;
        this.quarto = quarto;
        this.cliente = cliente;
    }

    @Override
    public void execute() {
        try {
            hotel.cancelarReserva(date, quarto, cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void undo() {

    }
}
