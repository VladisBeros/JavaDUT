package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Фонд Основания", "B001", "Айзек Азимов");
        DVD dvd1 = new DVD("Я, Робот", "D001", 148);

        library.add(book1);
        library.add(dvd1);

        Patron patron1 = new Patron("Элис Джонсон", "P001");
        library.registerPatron(patron1);

        System.out.println("\nПопытка взять уже взятую книгу:");
        library.lendItem(patron1, book1);

        Book book2 = new Book("1984", "B002", "Джордж Оруэлл");

        System.out.println("\nПопытка взять книгу, которой нет в библиотеке:");
        library.lendItem(patron1, book2);

        System.out.println("...");
        library.lendItem(patron1, book1);
        library.lendItem(patron1, dvd1);

        System.out.println("\nЗаемные средства:");
        for (Item item : library.listBorrowedItems()) {
            System.out.println(item.getTitle());
        }

        System.out.println("\nВозврат товаров...");
        library.returnItem(patron1, book1);
        library.returnItem(patron1, dvd1);

        System.out.println("\nДоступные товары после возврата:");
        for (Item item : library.listAvailableItems()) {
            System.out.println(item.getTitle());
        }
    }
}