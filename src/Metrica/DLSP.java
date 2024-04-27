package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DLSP extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener el total de ventas por fecha
        Map<String, Integer> cantidadPizzasPorFecha = new HashMap<>();

        // Calcular la suma de cantidad de pizzas para cada fecha
        for (Pizza pizza : pizzas) {
            String fecha = pizza.getOrderDate();
            int cantidadPizzas = (int) pizza.getQuantity(); // Convertimos la cantidad a entero
            // Si la fecha ya está en el mapa, sumamos la cantidad de pizzas nueva
            if (cantidadPizzasPorFecha.containsKey(fecha)) {
                cantidadPizzasPorFecha.put(fecha, cantidadPizzasPorFecha.get(fecha) + cantidadPizzas);
            } else { // Si no está en el mapa, la añadimos con su cantidad de pizzas
                cantidadPizzasPorFecha.put(fecha, cantidadPizzas);
            }
        }

        // Encontrar la fecha con la menor cantidad de pizzas vendidas
        int minCantidadPizzas = Integer.MAX_VALUE;
        String fechaMenosVentas = null;
        for (Map.Entry<String, Integer> entry : cantidadPizzasPorFecha.entrySet()) {
            String fecha = entry.getKey();
            int cantidadPizzas = entry.getValue();
            if (cantidadPizzas < minCantidadPizzas) {
                minCantidadPizzas = cantidadPizzas;
                fechaMenosVentas = fecha;
            }
        }

        // Devolver la fecha con menos ventas junto a la cantidad de pizzas vendidas
        return "Fecha con menos ventas en términos de cantidad de pizzas: " + fechaMenosVentas + ", Cantidad de pizzas vendidas: " + minCantidadPizzas;
    }
}
