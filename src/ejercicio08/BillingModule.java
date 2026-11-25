package ejercicio08;

/**
 * Módulo de facturación: emite una factura por cada egreso de stock.
 */
public class BillingModule implements StockListener {

    @Override
    public void onStockChanged(StockEvent event) {
        if (event.type() == StockChangeType.DECREASE) {
            System.out.println("Facturación: se emite factura por " + event.quantity() + " unidad(es) de " + event.productName());
        }
    }
}
