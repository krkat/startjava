package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    private static final String[] menu = new String[]{
            "1. Добавить книгу",
            "2. Получить книгу",
            "3. Удалить книгу",
            "4. Очистить шкаф",
            "5. Завершить"};

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        printMenu();
        bookshelf.print();
    }

    private static void printMenu() {
        for (String line : menu) {
            System.out.println(line);
        }
        System.out.println("Введите пункт меню: ");
    }

    private static void askToContinue() {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>.");
    }

    private Book inputBook(Scanner scanner) {
        System.out.println("Введите данные книги:");
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Год: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        return new Book(author, title, year);
    }
}
