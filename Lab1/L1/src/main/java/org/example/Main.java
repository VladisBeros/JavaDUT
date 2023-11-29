package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Монолит", "Шмитс", "978-0071808552", 2000));
        library.addBook(new Book("Вогонь та льод", "Мартин", "978-0132350884", 2001));

        System.out.println("Усi книги:");
        library.showBooks();

        System.out.println("\nЗнайденi книги за назвою:");
        Book foundBook = library.searchBookByTitle("Монолит");
        if (foundBook != null) {
            System.out.println("Знайдено: " + foundBook);
        } else {
            System.out.println("Не знайдено.");
        }

        System.out.println("\nВилучити книгу по ISBN:");
        boolean removed = library.removeBookByISBN("978-0071808552");
        if (removed) {
            System.out.println("Вилучено.");
        } else {
            System.out.println("Не вилучено.");
        }

        System.out.println("\nАпдейт книг у библiотеці:");
        library.showBooks();
    }
}