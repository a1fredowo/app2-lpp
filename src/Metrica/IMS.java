package Metrica;

import Lectura.Pizza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMS extends MetricaBase {

    @Override
    public String calcular(List<Pizza> pizzas) {
        // Mapa para mantener el conteo de cada ingrediente
        Map<String, Integer> conteoPorIngrediente = new HashMap<>();

        // Contar la cantidad de veces que aparece cada ingrediente en todas las pizzas
        for (Pizza pizza : pizzas) {
            String ingredientesString = pizza.getPizzaIngredients();
            ingredientesString = ingredientesString.substring(1, ingredientesString.length() - 1); // Eliminar las comillas al principio y al final
            String[] ingredientes = ingredientesString.split(",\\s*"); // Dividir por comas

            // Para cada ingrediente, incrementar el conteo en el mapa
            for (String ingrediente : ingredientes) {
                // Eliminar espacios en blanco al principio y al final de cada ingrediente
                ingrediente = ingrediente.trim();

                // Incrementar el conteo en el mapa
                if (conteoPorIngrediente.containsKey(ingrediente)) {
                    conteoPorIngrediente.put(ingrediente, conteoPorIngrediente.get(ingrediente) + 1);
                } else {
                    conteoPorIngrediente.put(ingrediente, 1);
                }
            }
        }

        // Encontrar el ingrediente con el mayor conteo
        int maxConteo = 0;
        String ingredienteMasFrecuente = null;
        for (Map.Entry<String, Integer> entry : conteoPorIngrediente.entrySet()) {
            String ingrediente = entry.getKey();
            int conteo = entry.getValue();
            if (conteo > maxConteo) {
                maxConteo = conteo;
                ingredienteMasFrecuente = ingrediente;
            }
        }

        return "El ingrediente más frecuente es: " + ingredienteMasFrecuente;
    }
}
