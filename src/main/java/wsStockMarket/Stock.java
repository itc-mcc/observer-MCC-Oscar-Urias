package wsStockMarket;

import java.util.ArrayList;

public class Stock implements Subject {
	String tipo; // Nombre del stock
	StockMarket mercado_acciones;
	ArrayList<Observer> obs;
	double precio;

	public Stock(String tipo, double precio_inicial, StockMarket mercado_acciones) {
		this.mercado_acciones = mercado_acciones;
		this.precio = precio_inicial;
		this.tipo = tipo;
		obs = new ArrayList<>();
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public void registerObservers(Observer o) {
		obs.add(o);
	}

	@Override
	public void removeObservers(Observer o) {
		int id = obs.indexOf(o);
		if (id >= 0)
			obs.remove(id);
	}

	@Override
	public String notifyObservers(Observer trader,String tipo_transaccion, Double precio) {
		String transaccionLog="";
		if (trader instanceof Trader) {
			for (Observer obs : obs) {
				transaccionLog = transaccionLog + obs.getName() + ":The latest trade is Trader:"+ trader.getName()+" "+tipo_transaccion
						+" $"+precio+ " Stock: "+ this.tipo+"\n";
			}
		}
		transaccionLog = transaccionLog.substring(0,transaccionLog.length()- 1); //eliminar ultimo caracter
		return transaccionLog;
	}
}