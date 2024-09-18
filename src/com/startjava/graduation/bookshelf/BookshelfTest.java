package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    private static final String menu = """
            1. Добавить книгу
            2. Получить книгу
            3. Удалить книгу
            4. Очистить шкаф
            5. Завершить
            """;

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу.");
        bookshelf.print();
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            answer = processAnswer(scanner, bookshelf);

        } while (answer != 5);

        System.out.println("\nВыход из программы.");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println(menu);
        System.out.print("Введите пункт меню: ");
    }

    private static void askToContinue() {
        System.out.println("Для продолжения работы нажмите клавишу <Enter>.");
    }

    private static Book inputBook(Scanner scanner) {
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Год: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return new Book(author, title, year);
    }

    private static int processAnswer(Scanner scanner, Bookshelf bookshelf) {
        printMenu();
        int item = scanner.nextInt();
        scanner.nextLine();
        switch(item) {
            case 1 -> addBook(scanner, bookshelf);
            case 2 -> findBook(scanner, bookshelf);
            case 3 -> deleteBook(scanner, bookshelf);
            case 4 -> clear(bookshelf);
            case 5 -> {
                return 5;
            }
                default -> {System.out.println("Неправильный пункт меню. Повторите ввод.");return 0;}
        }
        System.out.println();
        return item;
    }

    private static void addBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.println("Введите данные книги, которую хотите добавить.");
        Book book = inputBook(scanner);
        System.out.println("Добавление книги в шкаф...");
        bookshelf.add(book);
        bookshelf.print();
    }

    private static void findBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.println("Введите данные книги, которую хотите найти.");
        Book book = inputBook(scanner);
        System.out.println("Поиск книги в шкафу...");
        Book found = bookshelf.findAndGet(book);
        bookshelf.print();
    }

    private static void deleteBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.println("Введите данные книги, которую хотите удалить.");
        Book book = inputBook(scanner);
        System.out.println("Удаление книги из шкафа...");
        bookshelf.delete(book);
        bookshelf.print();
    }

    private static void clear(Bookshelf bookshelf) {
        System.out.println("Очистка шкафа...");
        bookshelf.clear();
        bookshelf.print();
    }
}