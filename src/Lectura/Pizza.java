package Lectura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private double pizzaId;
    private double orderId;
    private String pizzaNameId;
    private double quantity;
    private String orderDate;
    private String orderTime;
    private double unitPrice;
    private double totalPrice;
    private String pizzaSize;
    private String pizzaCategory;
    private String pizzaIngredients;
    private String pizzaName;

    // Constructor vacío para inicializar los atributos
    public Pizza() {
    }

    // Constructor con todos los atributos
    public Pizza(double pizzaId, double orderId, String pizzaNameId, double quantity, String orderDate, String orderTime, double unitPrice, double totalPrice, String pizzaSize, String pizzaCategory, String pizzaIngredients, String pizzaName) {
        this.pizzaId = pizzaId;
        this.orderId = orderId;
        this.pizzaNameId = pizzaNameId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.pizzaSize = pizzaSize;
        this.pizzaCategory = pizzaCategory;
        this.pizzaIngredients = pizzaIngredients;
        this.pizzaName = pizzaName;
    }

    // Getters y setters
    public double getPizzaId() {
        return pizzaId;
    }

    //Utilizamos excepciones para validar los valores de los atributos
    public void setPizzaId(double pizzaId) {
        if (pizzaId <= 0) {
            throw new IllegalArgumentException("El ID de la pizza no puede ser cero o negativo");
        }
        this.pizzaId = pizzaId;
    }

    public double getOrderId() {
        return orderId;
    }

    public void setOrderId(double orderId) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("El ID del pedido no puede ser cero o negativo");
        }
        this.orderId = orderId;
    }

    public String getPizzaNameId() {
        return pizzaNameId;
    }

    public void setPizzaNameId(String pizzaNameId) {
        if (pizzaNameId == null || pizzaNameId.isEmpty()) {
            throw new IllegalArgumentException("El ID del nombre de la pizza no puede ser nulo o vacío");
        }
        this.pizzaNameId = pizzaNameId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad de pizzas no puede ser cero o negativa");
        }
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        if (orderDate == null || orderDate.isEmpty()) {
            throw new IllegalArgumentException("La fecha del pedido no puede ser nula o vacía");
        }
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        if (orderTime == null || orderTime.isEmpty()) {
            throw new IllegalArgumentException("La hora del pedido no puede ser nula o vacía");
        }
        this.orderTime = orderTime;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("El precio unitario de la pizza no puede ser cero o negativo");
        }
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice <= 0) {
            throw new IllegalArgumentException("El precio total de la pizza no puede ser cero o negativo");
        }
        this.totalPrice = totalPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        if (pizzaSize == null || pizzaSize.isEmpty()) {
            throw new IllegalArgumentException("El tamaño de la pizza no puede ser nulo o vacío");
        }
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaCategory() {
        return pizzaCategory;
    }

    public void setPizzaCategory(String pizzaCategory) {
        if (pizzaCategory == null || pizzaCategory.isEmpty()) {
            throw new IllegalArgumentException("La categoría de la pizza no puede ser nula o vacía");
        }
        this.pizzaCategory = pizzaCategory;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        if (pizzaIngredients == null || pizzaIngredients.isEmpty()) {
            throw new IllegalArgumentException("Los ingredientes de la pizza no pueden ser nulos o vacíos");
        }
        this.pizzaIngredients = pizzaIngredients;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        if (pizzaName == null || pizzaName.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la pizza no puede ser nulo o vacío");
        }
        this.pizzaName = pizzaName;
    }

    public static List<Pizza> getAllPizzas(String filePath) {
        // Lista para almacenar todas las pizzas del archivo CSV
        List<Pizza> pizzas = new ArrayList<>();
        // Creamos un objeto CSVReader para leer el archivo CSV
        CSVReader csvReader = new CSVReader(filePath);
        try {
            // Leemos todos los registros del archivo CSV
            List<String[]> records = csvReader.readCSV();
            // Indicador para saltar la primera línea del archivo CSV que contiene los encabezados
            boolean firstLine = true;
            // Iteramos sobre cada registro del archivo CSV
            for (String[] values : records) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                // Creamos un objeto Pizza para almacenar los datos de la línea actual
                Pizza pizza = new Pizza();
                // Configuramos los atributos de la pizza con los valores del registro actual
                pizza.setPizzaId(Double.parseDouble(values[0].trim()));
                pizza.setOrderId(Double.parseDouble(values[1].trim()));
                pizza.setPizzaNameId(values[2].trim());
                pizza.setQuantity(Double.parseDouble(values[3].trim()));
                pizza.setOrderDate(values[4].trim());
                pizza.setOrderTime(values[5].trim());
                pizza.setUnitPrice(Double.parseDouble(values[6].trim()));
                pizza.setTotalPrice(Double.parseDouble(values[7].trim()));
                pizza.setPizzaSize(values[8].trim());
                pizza.setPizzaCategory(values[9].trim());
                pizza.setPizzaIngredients(values[10].trim());
                pizza.setPizzaName(values[11].trim());
                // Agregamos la pizza creada a la lista de pizzas
                pizzas.add(pizza);
            }
        } catch (IOException e) {
            // Excepción de entrada/salida (IOException) por si ocurre un error al leer el archivo CSV
            e.printStackTrace();
        }
        // Devolvemos la lista de pizzas obtenidas del archivo CSV
        return pizzas;
    }
}
    