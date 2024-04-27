package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HP extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener el total de pizzas por categoría
        Map<String, Integer> pizzasPorCategoria = new HashMap<>();

        // Calcular la cantidad de pizzas por categoría
        for (Pizza pizza : pizzas) {
            String categoria = pizza.getPizzaCategory();
            double cantidad = pizza.getQuantity();
            // Si la categoría ya está en el mapa, sumamos la cantidad nueva
            if (pizzasPorCategoria.containsKey(categoria)) {
                pizzasPorCategoria.put(categoria, pizzasPorCategoria.get(categoria) + (int) cantidad);
            } else { // Si no está en el mapa, añadimos la categoría con su cantidad de pizzas
                pizzasPorCategoria.put(categoria, (int) cantidad);
            }
        }

        // Construir la representación del resultado
        StringBuilder resultado = new StringBuilder("Cantidad de pizzas por categoría vendidas:\n");
        int count = 0;
        for (Map.Entry<String, Integer> entry : pizzasPorCategoria.entrySet()) {
            count++;
            resultado.append(entry.getKey()).append(": ").append(entry.getValue());
            // Agregar salto de línea si no es la última línea
            if (count < pizzasPorCategoria.size()) {
                resultado.append("\n");
            }
        }

        return resultado.toString();
    }
}
