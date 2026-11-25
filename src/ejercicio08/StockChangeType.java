package ejercicio08;

/**
 * Tipo de movimiento de stock.
 */
public enum StockChangeType {
    INCREASE("Ingreso"),
    DECREASE("Egreso");

    private final String label;

    StockChangeType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
