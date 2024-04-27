package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DMS extends MetricaBase {

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

        // Encontrar la fecha con la mayor cantidad de ventas
        double maxVenta = Double.MIN_VALUE;
        String fechaMasVentas = null;
        for (Map.Entry<String, Double> entry : ventasPorFecha.entrySet()) {
            String fecha = entry.getKey();
            double totalVenta = entry.getValue();
            if (totalVenta > maxVenta) {
                maxVenta = totalVenta;
                fechaMasVentas = fecha;
            }
        }

        // Devolver la fecha con más ventas junto a la cantidad de dinero recaudado
        return "Fecha con más ventas: " + fechaMasVentas + ", Cantidad de dinero recaudado: $" + maxVenta;
    }
}
