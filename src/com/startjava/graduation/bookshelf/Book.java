package com.startjava.graduation.bookshelf;

import java.util.Objects;

public class Book {
    private static final int YEAR_START_PRINT_BOOK = 1445;
    private static final int CURRENT_YEAR = 2024;
    private final String author;
    private final String title;
    private final int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        if (!isValid(year)) {
            throw new RuntimeException("Ошибка! Год издания неверный");
        }
        this.year = year;
    }

    private static boolean isValid(int year) {
        return year >= YEAR_START_PRINT_BOOK && year <= CURRENT_YEAR;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, year);
    }

    @Override
    public String toString() {
        return new StringBuilder(author).append(", ").append(title).append(", ").append(year).toString();
    }
}