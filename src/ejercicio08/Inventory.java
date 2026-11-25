package ejercicio08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Inventario (sujeto observable).
 * Solo gestiona su propio stock y notifica a su lista abstracta de oyentes.
 * No conoce ningún módulo concreto (facturación, estadísticas, etc.).
 */
public class Inventory {

    private final Map<String, Integer> stock = new HashMap<>();
    private final List<StockListener> listeners = new ArrayList<>();

    /**
     * Los oyentes se reciben desde afuera (inversión de control).
     */
    public Inventory(List<StockListener> initialListeners) {
        listeners.addAll(initialListeners);
    }

    public void addListener(StockListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeListener(StockListener listener) {
        listeners.remove(listener);
    }

    /**
     * Da de alta un producto con su stock inicial (no genera notificaciones).
     */
    public void registerProduct(String productName, int initialStock) {
        stock.put(productName, initialStock);
    }

    public void addStock(String productName, int quantity) {
        validate(productName, quantity);
        int newStock = stock.get(productName) + quantity;
        stock.put(productName, newStock);
        notifyListeners(new StockEvent(productName, StockChangeType.INCREASE, quantity, newStock));
    }

    public void removeStock(String productName, int quantity) {
        validate(productName, quantity);
        int current = stock.get(productName);
        if (quantity > current) {
            throw new IllegalArgumentException("Stock insuficiente de " + productName + ": hay " + current + " y se pidieron " + quantity);
        }
        int newStock = current - quantity;
        stock.put(productName, newStock);
        notifyListeners(new StockEvent(productName, StockChangeType.DECREASE, quantity, newStock));
    }

    public int getStock(String productName) {
        return stock.getOrDefault(productName, 0);
    }

    private void validate(String productName, int quantity) {
        if (!stock.containsKey(productName)) {
            throw new IllegalArgumentException("Producto desconocido: " + productName);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
    }

    private void notifyListeners(StockEvent event) {
        for (StockListener listener : new ArrayList<>(listeners)) {
            listener.onStockChanged(event);
        }
    }
}
