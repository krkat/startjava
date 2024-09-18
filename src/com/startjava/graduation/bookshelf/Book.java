package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private int year;

    @Override
    public String  toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
