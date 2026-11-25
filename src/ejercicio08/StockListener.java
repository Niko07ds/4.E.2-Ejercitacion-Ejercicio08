package ejercicio08;

/**
 * Abstracción que reemplaza las dependencias directas del inventario.
 * Cualquier módulo interesado en los movimientos de stock la implementa.
 */
public interface StockListener {

    void onStockChanged(StockEvent event);
}
