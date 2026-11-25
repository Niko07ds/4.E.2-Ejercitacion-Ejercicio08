package ejercicio08;

/**
 * Evento inmutable que describe un movimiento de stock.
 */
public record StockEvent(String productName, StockChangeType type, int quantity, int newStock) {
}
