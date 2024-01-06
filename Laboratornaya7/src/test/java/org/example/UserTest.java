package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class UserTest {

    private User user;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        user = new User(1, "Джон", new HashMap<>());
        product1 = new Product(1, "Яблуко", 0.50, 100);
        product2 = new Product(2, "Банан", 0.30, 150);
    }

    @Test
    public void testAddToCart() {
        user.addToCart(product1, 5);
        Assertions.assertEquals(5, user.getCart().get(product1));
    }

    @Test
    public void testRemoveFromCart() {
        user.addToCart(product1, 5);
        user.removeFromCart(product1);
        Assertions.assertFalse(user.getCart().containsKey(product1));
    }

    @Test
    public void testUpdateCart() {
        user.addToCart(product1, 5);
        user.updateCart(product1, 10);
        Assertions.assertEquals(10, user.getCart().get(product1));

        // Тестирование удаления товара из корзины при обновлении его количества до 0
        user.updateCart(product1, 0);
        Assertions.assertFalse(user.getCart().containsKey(product1));
    }

    @Test
    public void testUpdateCartWithNonExistingProduct() {
        user.updateCart(product2, 5);
        Assertions.assertFalse(user.getCart().containsKey(product2));
    }
}