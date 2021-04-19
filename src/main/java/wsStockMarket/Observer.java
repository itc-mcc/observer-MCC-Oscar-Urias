package wsStockMarket;

public interface Observer {

    public String getName();
    public void update(Subject s, String args, Double precio);

}
