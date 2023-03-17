package ru.job4j.pojo;

public class Library {

    public static void print(Book book) {
        System.out.println("Name:" + book.getName() + "\nQuantity: " + book.getQuantity() + "\n");
    }

    public static void main(String[] args) {
        Book firstBook = new Book("Head First Java", 100);
        Book secondBook = new Book("Java: A Beginner’s Guide", 150);
        Book thirdBook = new Book("Clean code", 125);
        Book fourthdBook = new Book("Java For Dummies", 98);
        Book temp = new Book();
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthdBook;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            print(books[i]);
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                print(book);
            }
        }
    }
}
