package wsStockMarket;

public interface Subject {
    public void registerObservers(Observer o);
    public void removeObservers(Observer o);
    public String notifyObservers(Observer t, String tipo_transaccion, Double precio);
}
