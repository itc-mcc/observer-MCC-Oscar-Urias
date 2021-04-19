package wsStockMarket;

import java.util.HashMap;
import java.util.Map;

public class Trader implements Observer {
	String name;
	StockMarket mercado_acciones;
	private Map<Stock,Double> stocks; // cuales stocks posee este trader. Stock - precio de stock

	public Trader(String nombre, StockMarket mercado_acciones) {
		this.name = nombre;
		this.mercado_acciones = mercado_acciones;
		this.stocks = new HashMap<>();
	}
	public String getName() {
		return this.name;
	}

	public void update(Subject s, String tipo_transaccion, Double precio) {
		if (s instanceof Stock) {
			Stock stock = (Stock) s;
			if (tipo_transaccion == "buy") {
				this.stocks.put(stock, precio);
			}
			if (tipo_transaccion == "sell")
				this.stocks.remove(stock);
		}
	}
}