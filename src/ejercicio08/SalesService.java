package ejercicio08;

/**
 * Clase de negocio que registra ventas. Solo conoce el inventario,
 * no los módulos que reciben las actualizaciones de stock.
 */
public class SalesService {

    private final Inventory inventory;

    public SalesService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void sell(String productName, int quantity) {
        System.out.println("Ventas: se vende " + quantity + " unidad(es) de " + productName);
        inventory.removeStock(productName, quantity);
    }
}
