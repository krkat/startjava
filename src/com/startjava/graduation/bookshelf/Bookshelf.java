package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int SHELVES = 10;
    private int countBooks;
    private final Book[] books = new Book[SHELVES];

    public void add(Book book) {
        if (countBooks == books.length) {
            throw new RuntimeException("Место в шкафу кончилось!" +
                    " Попробуйте удалить книгу или очистить шкаф.");
        }
        books[countBooks] = book;
        countBooks++;
    }

    public Book[] findAndGet(String title) {
        Book[] founded = new Book[10];
        int index = 0;
        for (Book book : books) {
            if (book != null && title.equals(book.getTitle())) {
                founded[index] = book;
                index++;
            }
        }
        if (founded[0] == null) {
            throw new RuntimeException("Книги с таким названием не найдены.");
        }
        return Arrays.copyOf(founded, index);
    }

    public void delete(String title) {
        if (findAndGet(title) != null) {
            int countDeleted = countBooks;
            for (int i = 0; i < countBooks; i++) {
                if (title.equals(books[i].getTitle())) {
                    System.arraycopy(books, i + 1, books, i, countBooks - i - 1);
                    books[countBooks - 1] = null;
                    countBooks--;
                    i = i - 1;
                }
            }
            System.out.printf("С названием %s удалено из шкафа книг: %d%n", title, countDeleted - countBooks);
        }
    }

    public void clear() {
        if (countBooks == 0) {
            System.out.println("Шкаф уже пуст.");
            return;
        }
        Arrays.fill(books, null);
        countBooks = 0;
        System.out.println("Шкаф очищен.");
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getCountBooks() {
        return this.countBooks;
    }

    public int getEmptyShelves() {
        return books.length - countBooks;
    }

    public void print() {
        if (countBooks > 0) {
            System.out.printf("\nВ шкафу книг - %d, свободных полок - %d%n",
                    getCountBooks(), getEmptyShelves());
            System.out.println("-".repeat(60));
            for (Book book : getAllBooks()) {
                System.out.printf("|%-58s|%n", book);
                System.out.println("-".repeat(60));
            }
        } else {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу.");
        }
    }
}