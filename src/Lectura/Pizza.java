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

    // Constructor vacío
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

    public void setPizzaId(double pizzaId) {
        this.pizzaId = pizzaId;
    }

    public double getOrderId() {
        return orderId;
    }

    public void setOrderId(double orderId) {
        this.orderId = orderId;
    }

    public String getPizzaNameId() {
        return pizzaNameId;
    }

    public void setPizzaNameId(String pizzaNameId) {
        this.pizzaNameId = pizzaNameId;

    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaCategory() {
        return pizzaCategory;
    }

    public void setPizzaCategory(String pizzaCategory) {
        this.pizzaCategory = pizzaCategory;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public static List<Pizza> getAllPizzas(String filePath) {
        List<Pizza> pizzas = new ArrayList<>();
        CSVReader csvReader = new CSVReader(filePath);
        try {
            List<String[]> records = csvReader.readCSV();
            // Saltar la primera línea del archivo CSV (encabezados)
            boolean firstLine = true;
            for (String[] values : records) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Saltar esta línea
                }
                Pizza pizza = new Pizza();
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
                pizzas.add(pizza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pizzas;
    }
}
    