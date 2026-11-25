package ejercicio08;

/**
 * Módulo de estadísticas: acumula las unidades que ingresan y las que salen.
 */
public class StatisticsModule implements StockListener {

    private int unitsIn;
    private int unitsOut;

    @Override
    public void onStockChanged(StockEvent event) {
        if (event.type() == StockChangeType.INCREASE) {
            unitsIn += event.quantity();
        } else {
            unitsOut += event.quantity();
        }
        System.out.println("Estadísticas: " + event.type().getLabel() + " de " + event.productName()
                + " registrado (stock actual " + event.newStock() + ")");
    }

    public void printSummary() {
        System.out.println("Resumen de estadísticas: " + unitsIn + " unidad(es) ingresadas, " + unitsOut + " unidad(es) vendidas");
    }
}
