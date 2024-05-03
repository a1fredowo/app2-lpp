package Metrica;

import Lectura.Pizza;
import java.util.List;

public abstract class MetricaBase {
    // Método abstracto para todas las métricas
    public abstract String calcular(List<Pizza> pizzas);
}
