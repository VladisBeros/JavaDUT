package org.example;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username, Map<Product, Integer> cart) {
        this.id = id;
        this.username = username;
        this.cart = cart;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Map<Product, Integer> getCart() { return cart; }
    public void setCart(Map<Product, Integer> cart) { this.cart = cart; }

    public void addToCart(Product product, int quantity) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public void updateCart(Product product, int quantity) {
        if (cart.containsKey(product)) {
            if (quantity > 0) {
                cart.put(product, quantity);
            } else {
                removeFromCart(product);
            }
        }
    }

    public String getCartContents() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            sb.append(entry.getKey().toString()).append(" - Кількість: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}

