package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class ECommercePlatformTest {

    private ECommercePlatform platform;
    private User user;
    private Product product;

    @BeforeEach
    public void setUp() {
        platform = new ECommercePlatform();
        user = new User(1, "Джон", new HashMap<>());
        product = new Product(1, "Яблуко", 0.50, 100);
    }

    @Test
    public void testAddUser() {
        platform.addUser(user);
        Assertions.assertTrue(platform.getUsersList().contains("Джон"));
    }

    @Test
    public void testAddProduct() {
        platform.addProduct(product);
        Assertions.assertTrue(platform.getAvailableProducts().contains("Яблуко"));
    }

    @Test
    public void testCreateOrder() {
        platform.addUser(user);
        platform.addProduct(product);
        user.addToCart(product, 5);
        platform.createOrder(1, user);

        String ordersList = platform.getOrdersList();
        Assertions.assertTrue(ordersList.contains("ID замовлення: 1"));
        Assertions.assertTrue(ordersList.contains("ID користувача: 1"));
        Assertions.assertTrue(ordersList.contains("Загальна сума: 2.5"));
    }

    @Test
    public void testUpdateProductStock() {
        platform.addProduct(product);
        platform.updateProductStock(product.getId(), 80);
        String availableProducts = platform.getAvailableProducts();
        Assertions.assertTrue(availableProducts.contains("склад = 80"));
    }
}


