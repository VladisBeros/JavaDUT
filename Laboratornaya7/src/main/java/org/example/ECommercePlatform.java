package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        users = new HashMap<>();
        products = new HashMap<>();
        orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer orderId, User user) {
        Order order = new Order(orderId, user.getId(), new HashMap<>(user.getCart()));
        orders.put(orderId, order);
        user.setCart(new HashMap<>());
    }

    public String getAvailableProducts() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products.values()) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getUsersList() {
        StringBuilder sb = new StringBuilder();
        for (User user : users.values()) {
            sb.append(user.getUsername()).append("\n");
        }
        return sb.toString();
    }

    public String getOrdersList() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders.values()) {
            sb.append("ID замовлення: ").append(order.getId())
                    .append(", ID користувача: ").append(order.getUserId())
                    .append(", Загальна сума: ").append(order.getTotalPrice())
                    .append("\n");
        }
        return sb.toString();
    }

    public void updateProductStock(Integer productId, int newStock) {
        if (products.containsKey(productId)) {
            products.get(productId).setStock(newStock);
        }
    }

    public List<Product> sortProductsByName() {
        return products.values().stream()
                .sorted(new ProductNameComparator())
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByPrice() {
        return products.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByStock() {
        return products.values().stream()
                .sorted(new ProductStockComparator())
                .collect(Collectors.toList());
    }

    public List<Product> filterProductsByStockAvailability() {
        return products.values().stream()
                .filter(p -> p.getStock() > 0)
                .collect(Collectors.toList());
    }

    public List<Product> recommendProducts(User user) {
        return products.values().stream()
                .filter(p -> !user.getCart().containsKey(p))
                .collect(Collectors.toList());
    }
}

