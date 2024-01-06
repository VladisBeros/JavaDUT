package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class OrderTest {

    @Test
    public void testOrderCreationAndTotalPriceCalculation() {
        Map<Product, Integer> orderDetails = new HashMap<>();
        Product product = new Product(1, "Яблуко", 0.50, 100);
        orderDetails.put(product, 10);

        Order order = new Order(1, 1, orderDetails);
        Assertions.assertEquals(5.0, order.getTotalPrice());
    }
}

