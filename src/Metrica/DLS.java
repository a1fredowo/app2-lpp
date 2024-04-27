package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DLS extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener el total de ventas por fecha
        Map<String, Double> ventasPorFecha = new HashMap<>();

        // Calcular la suma de ventas para cada fecha
        for (Pizza pizza : pizzas) {
            String fecha = pizza.getOrderDate();
            double totalVenta = pizza.getTotalPrice();
            // Si la fecha ya está en el mapa, sumamos el total de venta nuevo
            if (ventasPorFecha.containsKey(fecha)) {
                ventasPorFecha.put(fecha, ventasPorFecha.get(fecha) + totalVenta);
            } else { // Si no está en el mapa, la añadimos con su total de venta
                ventasPorFecha.put(fecha, totalVenta);
            }
        }

        // Encontrar la fecha con la menor cantidad de ventas
        double minVenta = Double.MAX_VALUE;
        String fechaMenosVentas = null;
        for (Map.Entry<String, Double> entry : ventasPorFecha.entrySet()) {
            String fecha = entry.getKey();
            double totalVenta = entry.getValue();
            if (totalVenta < minVenta) {
                minVenta = totalVenta;
                fechaMenosVentas = fecha;
            }
        }

        // Devolver la fecha con menos ventas junto a la cantidad de dinero recaudado
        return "Fecha con menos ventas: " + fechaMenosVentas + ", Cantidad de dinero recaudado: $" + minVenta;
    }
}
