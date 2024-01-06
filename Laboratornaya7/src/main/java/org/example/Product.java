package org.example;

public class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private double price;
    private int stock;

    public Product(Integer id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Продукт {" +
                "ID = " + id +
                ", ім'я = " + name + '\'' +
                ", ціна = " + price +
                ", склад = " + stock +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
}
