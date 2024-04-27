package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APO extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener el total de cantidades de cada orden
        Map<Double, Double> cantidadPorOrden = new HashMap<>();
        Map<Double, Integer> cantidadDeOrdenes = new HashMap<>();

        // Calcular la cantidad de pizzas por orden y el total de órdenes
        for (Pizza pizza : pizzas) {
            double orderID = pizza.getOrderId();
            double cantidad = pizza.getQuantity();
            // Si el ID de orden ya está en el mapa, sumamos la cantidad nueva
            if (cantidadPorOrden.containsKey(orderID)) {
                cantidadPorOrden.put(orderID, cantidadPorOrden.get(orderID) + cantidad);
            } else { // Si no está en el mapa, añadimos la cantidad
                cantidadPorOrden.put(orderID, cantidad);
                cantidadDeOrdenes.put(orderID, 1);
            }
        }

        // Calcular el promedio de pizzas por orden
        double totalPizzas = 0;
        int totalOrdenes = cantidadDeOrdenes.size(); // Total de órdenes distintas
        for (double cantidad : cantidadPorOrden.values()) {
            totalPizzas += cantidad;
        }

        double promedio = totalPizzas / totalOrdenes;
        // Redondear el promedio a 2 decimales
        promedio = Math.round(promedio * 100.0) / 100.0;

        return "El promedio de pizzas por orden es: " + promedio;
    }
}
