package com.startjava.graduation.bookshelf;

import java.util.Objects;

public class Book {
    private static final int YEAR_START_PRINT_BOOK = 1445;
    private static final int CURRENT_YEAR = 2024;
    private final String author;
    private final String title;
    private final int publicationYear;

    public Book(String author, String title, int publicationYear) {
        this.author = author;
        this.title = title;
        if (!isValid(publicationYear)) {
            throw new RuntimeException("Ошибка! Год издания неверный");
        }
        this.publicationYear = publicationYear;
    }

    private static boolean isValid(int publicationYear) {
        return publicationYear >= YEAR_START_PRINT_BOOK && publicationYear <= CURRENT_YEAR;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, publicationYear);
    }

    @Override
    public String toString() {
        return new StringBuilder(author).append(", ")
                .append(title).append(", ").append(publicationYear).toString();
    }
}