package Metrica;

import Lectura.Pizza;
import java.util.List;

public abstract class MetricaBase {
    // Método abstracto para calcular la métrica
    public abstract String calcular(List<Pizza> pizzas);
}
