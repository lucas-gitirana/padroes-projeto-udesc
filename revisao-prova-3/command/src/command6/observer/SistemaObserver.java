package command6.observer;

public class SistemaObserver implements Observer{

    private double total;

    @Override
    public void realizouCheckout(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
