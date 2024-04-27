package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APD extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener la cantidad de pizzas por día
        Map<String, Integer> pizzasPorDia = new HashMap<>();

        // Calcular la cantidad de pizzas por día
        for (Pizza pizza : pizzas) {
            String fecha = pizza.getOrderDate();
            int cantidadPizzas = (int) pizza.getQuantity(); // Convertimos la cantidad a entero
            // Si la fecha ya está en el mapa, sumamos la cantidad de pizzas nueva
            if (pizzasPorDia.containsKey(fecha)) {
                pizzasPorDia.put(fecha, pizzasPorDia.get(fecha) + cantidadPizzas);
            } else { // Si no está en el mapa, la añadimos con su cantidad de pizzas
                pizzasPorDia.put(fecha, cantidadPizzas);
            }
        }

        // Calcular el total de días y la cantidad total de pizzas
        int totalDias = pizzasPorDia.size();
        int totalPizzas = 0;
        for (int cantidad : pizzasPorDia.values()) {
            totalPizzas += cantidad;
        }

        // Calcular el promedio de pizzas por día
        double promedioPizzasPorDia = (double) totalPizzas / totalDias;

        // Devolver el promedio de pizzas por día con dos decimales de precisión
        return String.format("Promedio de pizzas por día: %.2f", promedioPizzasPorDia);
    }
}