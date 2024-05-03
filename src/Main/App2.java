package Main;

// Importación de clases necesarias
import Lectura.Pizza;
import Metrica.*;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        // Verificamos de que se hayan proporcionado al menos dos argumentos en la línea de comandos
        if (args.length < 2) {
            System.out.println("Uso: java App2 <archivo_CSV> <métrica1> <métrica2> ... <métricaN>");
            return;
        }

        // Obtenemos la ruta del archivo CSV a partir del primer argumento dado
        String filePath = args[0];
        
        // Creamos una lista para almacenar las métricas especificadas en la línea de comandos
        List<String> metricas = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            metricas.add(args[i]);
        }

        // Iteramos sobre cada métrica especificada en la lista
        for (String metrica : metricas) {
            // Selección de la métrica a ejecutar según el argumento dado
            if (metrica.equals("pms")) {
                // Obtenemos todas las pizzas del archivo CSV
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                // Creamos una instancia de la métrica PMS
                MetricaBase pmsMetrica = new PMS();
                // Ejecutamos el cálculo de la métrica
                String pizzaMasVendida = pmsMetrica.calcular(pizzas);
                // Imprimimos el resultado de la métrica en la consola
                System.out.println("La pizza más vendida es: " + pizzaMasVendida);
            // Asi para todas las metricas
            } else if (metrica.equals("pls")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase plsMetrica = new PLS();
                String pizzaMenosVendida = plsMetrica.calcular(pizzas);
                System.out.println("La pizza menos vendida es: " + pizzaMenosVendida);
            } else if (metrica.equals("dms")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase dmsMetrica = new DMS();
                String fechaMasVentas = dmsMetrica.calcular(pizzas);
                System.out.println(fechaMasVentas);
            } else if (metrica.equals("dls")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase dlsMetrica = new DLS();
                String fechaMenosVentas = dlsMetrica.calcular(pizzas);
                System.out.println(fechaMenosVentas);
            } else if (metrica.equals("dmsp")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase dmspMetrica = new DMSP();
                String fechaMasVentasPizzas = dmspMetrica.calcular(pizzas);
                System.out.println(fechaMasVentasPizzas);
            } else if (metrica.equals("dlsp")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase dlspMetrica = new DLSP();
                String fechaMenosVentas = dlspMetrica.calcular(pizzas);
                System.out.println(fechaMenosVentas);
            } else if (metrica.equals("apd")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase apdMetrica = new APD();
                String promedioPizzasPorDia = apdMetrica.calcular(pizzas);
                System.out.println(promedioPizzasPorDia);
            } else if (metrica.equals("apo")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase apoMetrica = new APO();
                String promedioPizzasPorOrden = apoMetrica.calcular(pizzas);
                System.out.println(promedioPizzasPorOrden);
            } else if (metrica.equals("ims")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase imsMetrica = new IMS();
                String ingredientesMasVendidos = imsMetrica.calcular(pizzas);
                System.out.println(ingredientesMasVendidos);
            } else if (metrica.equals("hp")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase hpMetrica = new HP();
                String pizzasPorCategoria = hpMetrica.calcular(pizzas);
                System.out.println(pizzasPorCategoria);
            } else {
                System.out.println("Métrica no válida.");
            }
        }
    }
}
