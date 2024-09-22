package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int SHELVES = 10;
    private final Book[] books = new Book[SHELVES];
    private int countBooks;

    public int getCountBooks() {
        return countBooks;
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getEmptyShelves() {
        return SHELVES - countBooks;
    }

    public void add(Book book) {
        if (countBooks >= SHELVES) {
            throw new RuntimeException("Место в шкафу кончилось!" +
                    " Попробуйте удалить книгу или очистить шкаф.");
        }
        books[countBooks++] = book;
    }

    public Book[] find(String title) {
        Book[] founded = new Book[SHELVES];
        int index = 0;
        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                founded[index] = books[i];
                index++;
            }
        }
        if (founded[0] == null) {
            throw new RuntimeException("Книги с таким названием не найдены.");
        }
        return Arrays.copyOf(founded, index);
    }

    public int delete(String title) {
        int countDeleted = 0;
        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                System.arraycopy(books, i + 1, books, i, countBooks - i - 1);
                books[countBooks - 1] = null;
                countDeleted++;
                countBooks--;
                i--;
            }
        }
        return countDeleted;
    }

    public boolean clear() {
        if (countBooks == 0) {
            return false;
        }
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
        return true;
    }
}