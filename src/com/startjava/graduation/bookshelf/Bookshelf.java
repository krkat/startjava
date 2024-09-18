package com.startjava.graduation.bookshelf;

public class Bookshelf {
    private int countBooks;
    private Book[] books = new Book[10];
    private int shelves;

    public Bookshelf(int shelves) {
        this.shelves = shelves;
    }

    public void add(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }
        countBooks++;
    }

    public Book findAndGet(Book book){
        return null;
    }

    public void delete(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals(book)) {
                books[i] = null;
            }
        }
        countBooks--;
    }

    public void clear() {
        for (int i = 0; i < books.length; i++) {
            books[i] = null;
        }
        countBooks = 0;
    }

    public Book[] getAllBooks() {
        return this.books;
    }

    public int getCountBooks() {
        return this.countBooks;
    }

    public int getEmptyShelves() {
        return 0;
    }

    public void print() {
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.printf("|%-58s|%n", books[i].toString());
            } else {
                System.out.println("|                                                          |");
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}