package org.example;

class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void borrowItem() {
        if (!this.isBorrowed) {
            this.isBorrowed = true;
            System.out.println("Книга, взятая взаймы: " + this.title);
        } else {
            System.out.println("Книга уже взята на время.");
        }
    }

    @Override
    public void returnItem() {
        if (this.isBorrowed) {
            this.isBorrowed = false;
            System.out.println("Книга возвращена: " + this.title);
        } else {
            System.out.println("Книга не была взята.");
        }
    }
}