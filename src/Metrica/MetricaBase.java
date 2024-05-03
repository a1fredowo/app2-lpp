package Metrica;

import Lectura.Pizza;
import java.util.List;

// Clase abstracta que define el método calcular que será implementado por todas las metricas
public abstract class MetricaBase {
    public abstract String calcular(List<Pizza> pizzas);
}