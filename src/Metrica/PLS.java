package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PLS extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener el total de cantidades de cada pizza
        Map<String, Double> cantidadPorPizza = new HashMap<>();

        // Calcular la suma de las cantidades para cada pizza
        for (Pizza pizza : pizzas) {
            String nombrePizza = pizza.getPizzaName();
            double cantidad = pizza.getQuantity();
            // Si la pizza ya está en el mapa, sumamos la cantidad nueva
            if (cantidadPorPizza.containsKey(nombrePizza)) {
                cantidadPorPizza.put(nombrePizza, cantidadPorPizza.get(nombrePizza) + cantidad);
            } else { // Si no está en el mapa, la añadimos con su cantidad
                cantidadPorPizza.put(nombrePizza, cantidad);
            }
        }

        // Encontrar la pizza con la cantidad más baja
        double minCantidad = Double.MAX_VALUE;
        String pizzaMenosVendida = null;
        for (Map.Entry<String, Double> entry : cantidadPorPizza.entrySet()) {
            String nombrePizza = entry.getKey();
            double cantidad = entry.getValue();
            if (cantidad < minCantidad) {
                minCantidad = cantidad;
                pizzaMenosVendida = nombrePizza;
            }
        }

        return pizzaMenosVendida;
    }
}
