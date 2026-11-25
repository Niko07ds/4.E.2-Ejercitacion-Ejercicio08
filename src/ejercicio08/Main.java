package ejercicio08;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Único lugar donde se conocen los módulos concretos: la composición del programa
        BillingModule billing = new BillingModule();
        StatisticsModule statistics = new StatisticsModule();

        Inventory inventory = new Inventory(List.of(billing, statistics));
        SalesService sales = new SalesService(inventory);

        inventory.registerProduct("Monitor 24 pulgadas", 10);
        inventory.registerProduct("Mouse inalámbrico", 20);
        System.out.println("Inventario inicial: 10 monitores y 20 mouses");

        System.out.println();
        System.out.println("Se vende un monitor");
        sales.sell("Monitor 24 pulgadas", 1);

        System.out.println();
        System.out.println("Ingresa mercadería al depósito");
        inventory.addStock("Mouse inalámbrico", 5);

        System.out.println();
        System.out.println("Se desvincula el módulo de facturación y se vende un mouse");
        inventory.removeListener(billing);
        sales.sell("Mouse inalámbrico", 1);

        System.out.println();
        System.out.println("Intento de vender más unidades de las disponibles");
        try {
            sales.sell("Monitor 24 pulgadas", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Operación rechazada: " + e.getMessage());
        }

        System.out.println();
        statistics.printSummary();
    }
}
