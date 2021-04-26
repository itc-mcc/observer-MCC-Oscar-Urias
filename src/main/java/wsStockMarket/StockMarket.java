package wsStockMarket;

public class StockMarket {
	public StockMarket() {
	}

	public void register(Trader t, Stock s) {
		s.registerObservers(t);
	}

	public String trade(Trader t, Stock s, String tipo_transaccion, double precio) {
		t.update(s, tipo_transaccion, precio);
		String TransactionLog = s.notifyObservers(t, tipo_transaccion, precio);
		return TransactionLog;
	}
}