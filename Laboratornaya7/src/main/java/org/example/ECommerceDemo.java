package org.example;
import java.util.HashMap;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "Джон", new HashMap<>());
        User user2 = new User(2, "Джейн", new HashMap<>());
        platform.addUser(user1);
        platform.addUser(user2);

        Product apple = new Product(1, "Яблуко", 0.50, 100);
        Product banana = new Product(2, "Банан", 0.30, 150);
        platform.addProduct(apple);
        platform.addProduct(banana);

        user1.addToCart(apple, 5);
        user2.addToCart(banana, 3);

        platform.createOrder(1, user1);
        platform.createOrder(2, user2);

        System.out.println("Доступні продукти:\n" + platform.getAvailableProducts());
        System.out.println("Список користувачів:\n" + platform.getUsersList());
        System.out.println("Список замовлень:\n" + platform.getOrdersList());

        platform.updateProductStock(apple.getId(), 80);
        System.out.println("Товари відсортовані за ціною:\n" + platform.sortProductsByPrice());
        System.out.println("Товари відсортовані за складом:\n" + platform.sortProductsByStock());

        System.out.println("Рекомендовані продукти для User1:\n" + platform.recommendProducts(user1));
        System.out.println("Рекомендовані продукти для User2:\n" + platform.recommendProducts(user2));
    }
}


