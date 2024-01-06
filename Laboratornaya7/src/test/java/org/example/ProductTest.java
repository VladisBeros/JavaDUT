package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product(1, "Яблуко", 0.50, 100);
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("Яблуко", product.getName());
        Assertions.assertEquals(0.50, product.getPrice());
        Assertions.assertEquals(100, product.getStock());
    }
}
