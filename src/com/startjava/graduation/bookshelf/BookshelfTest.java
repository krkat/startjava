package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String menu = """
            1. Добавить книгу
            2. Получить книгу
            3. Удалить книгу
            4. Очистить шкаф
            5. Завершить""";

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.print();
        Scanner scanner = new Scanner(System.in);
        int answer;
        boolean isRightAnswer = true;
        do {
            answer = processAnswer(scanner, bookshelf, isRightAnswer);
            if (answer == 0) {
                isRightAnswer = false;
                continue;
            }
            isRightAnswer = true;
        } while (answer != 5);
        System.out.println("\nВыход из программы.");
        scanner.close();
    }

    private static int processAnswer(Scanner scanner, Bookshelf bookshelf, boolean isRightAnswer) {
        if (isRightAnswer) {
            printMenu();
            System.out.print("Введите пункт меню: ");
        } else {
            System.out.print("Ошибка! Введите корректный пункт из списка: ");
        }
        int item;
        try {
            item = scanner.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        } finally {
            scanner.nextLine();
        }
        try {
            switch (item) {
                case 1 -> addBook(scanner, bookshelf);
                case 2 -> findBook(scanner, bookshelf);
                case 3 -> deleteBook(scanner, bookshelf);
                case 4 -> clear(bookshelf);
                case 5 -> {
                    return 5;
                }
                default -> {
                    return 0;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>.");
        askToContinue(scanner);
        bookshelf.print();
        return item;
    }

    private static void printMenu() {
        System.out.println("\n" + menu);
    }

    private static Book inputBook(Scanner scanner) {
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Год: ");
        int year;
        try {
            year = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException("\nОшибка! Год введен некорректно.");
        } finally {
            scanner.nextLine();
        }
        System.out.println();
        return new Book(author, title, year);
    }

    private static void addBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.println("Введите данные книги, которую хотите добавить.");
        Book book = inputBook(scanner);
        System.out.println("Добавление книги в шкаф...");
        bookshelf.add(book);
    }

    private static void findBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.print("Введите название книги, которую хотите найти: ");
        String title = scanner.nextLine();
        System.out.println("Поиск книги в шкафу...");
        Book[] founded = bookshelf.findAndGet(title);
        System.out.println("Найденные книги: ");
        for (Book book : founded) {
            System.out.println(book);
        }
    }

    private static void deleteBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.print("Введите название книги, которую хотите удалить: ");
        String title = scanner.nextLine();
        System.out.println("Удаление книги из шкафа...");
        bookshelf.delete(title);
    }

    private static void clear(Bookshelf bookshelf) {
        System.out.println("Очистка шкафа...");
        bookshelf.clear();
    }

    private static void askToContinue(Scanner scanner) {
        String answer;
        do {
            answer = scanner.nextLine();
        } while (!answer.isEmpty());
    }
}