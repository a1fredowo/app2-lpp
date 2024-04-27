package Main;

import Lectura.Pizza;
import Metrica.APD;
import Metrica.DLS;
import Metrica.DMS;
import Metrica.DMSP;
import Metrica.MetricaBase;
import Metrica.PLS;
import Metrica.PMS;
import Metrica.DLSP;
import Metrica.APO;
import Metrica.IMS;
import Metrica.HP;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java App2 <archivo_CSV> <métrica1> <métrica2> ... <métricaN>");
            return;
        }

        String filePath = args[0];
        
        List<String> metricas = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            metricas.add(args[i]);
        }

        for (String metrica : metricas) {
            if (metrica.equals("pms")) {
                List<Pizza> pizzas = Lectura.Pizza.getAllPizzas(filePath);
                MetricaBase pmsMetrica = new PMS();
                String pizzaMasVendida = pmsMetrica.calcular(pizzas);
                System.out.println("La pizza más vendida es: " + pizzaMasVendida);
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
                System.out.println("Métrica no válida. Las métricas disponibles son: pms, pls");
            }
        }
    }
}
