package com.startjava.graduation.bookshelf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookshelfTest {
    private static final String MENU = """
            1. Добавить книгу
            2. Получить книгу
            3. Удалить книгу
            4. Очистить шкаф
            5. Завершить""";
    private static final int ERROR_ITEM = 0;
    private static final int ADD_ITEM = 1;
    private static final int FIND_ITEM = 2;
    private static final int DELETE_ITEM = 3;
    private static final int CLEAR_ITEM = 4;
    private static final int EXIT_ITEM = 5;

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        Scanner scanner = new Scanner(System.in);
        int answer;
        boolean isRightAnswer = true;
        do {
            if (isRightAnswer) {
                print(bookshelf);
                printMenu();
                System.out.print("Введите пункт меню: ");
            } else {
                System.out.print("Ошибка! Введите корректный пункт из списка: ");
            }
            answer = chooseItem(scanner, bookshelf);
            if (answer == ERROR_ITEM) {
                isRightAnswer = false;
                continue;
            }
            if (answer != EXIT_ITEM) {
                isRightAnswer = true;
                askToContinue(scanner);
            }
        } while (answer != EXIT_ITEM);
        System.out.println("\nВыход из программы.");
        scanner.close();
    }

    private static int chooseItem(Scanner scanner, Bookshelf bookshelf) {
        int item = inputItem(scanner);
        try {
            switch (item) {
                case ADD_ITEM -> addBook(scanner, bookshelf);
                case FIND_ITEM -> findBook(scanner, bookshelf);
                case DELETE_ITEM -> deleteBook(scanner, bookshelf);
                case CLEAR_ITEM -> clear(bookshelf);
                case EXIT_ITEM -> {
                    return EXIT_ITEM;
                }
                default -> {
                    return ERROR_ITEM;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    private static void printMenu() {
        System.out.println("\n" + MENU);
    }

    private static int inputItem(Scanner scanner) {
        int item;
        try {
            item = scanner.nextInt();
        } catch (InputMismatchException e) {
            return ERROR_ITEM;
        } finally {
            scanner.nextLine();
        }
        return item;
    }

    private static void addBook(Scanner scanner, Bookshelf bookshelf) {
        System.out.println("Введите данные книги, которую хотите добавить.");
        Book book = inputBook(scanner);
        System.out.println("Добавление книги в шкаф...");
        bookshelf.add(book);
    }

    private static Book inputBook(Scanner scanner) {
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Год издания: ");
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

    private static void findBook(Scanner scanner, Bookshelf bookshelf) {
        String title = inputTitle("найти: ", scanner);
        System.out.println("Поиск книги в шкафу...");
        Book[] founded = bookshelf.find(title);
        System.out.println("Найденные книги: ");
        for (Book book : founded) {
            System.out.println(book);
        }
    }

    private static String inputTitle(String s, Scanner scanner) {
        System.out.print("Введите название книги, которую хотите " + s);
        return scanner.nextLine();
    }

    private static void deleteBook(Scanner scanner, Bookshelf bookshelf) {
        String title = inputTitle("удалить: ", scanner);
        System.out.println("Удаление книги из шкафа...");
        int countDeleted = bookshelf.delete(title);
        if (countDeleted > 0) {
            System.out.printf("С названием %s удалено из шкафа книг: %d%n", title, countDeleted);
        } else {
            System.out.println("Книги с таким названием не найдены.");
        }
    }

    private static void clear(Bookshelf bookshelf) {
        System.out.println("Очистка шкафа...");
        System.out.print("Шкаф ");
        System.out.println(bookshelf.clear() ? "очищен." : "уже пуст.");
    }

    public static void print(Bookshelf bookshelf) {
        int countBooks = bookshelf.getCountBooks();
        if (countBooks > 0) {
            System.out.printf("\nВ шкафу книг - %d, свободных полок - %d%n",
                    countBooks, bookshelf.getEmptyShelves());
            System.out.println("-".repeat(60));
            for (Book book : bookshelf.getAllBooks()) {
                System.out.printf("|%-58s|%n", book);
                System.out.println("-".repeat(60));
            }
        } else {
            System.out.println("\nШкаф пуст. Вы можете добавить в него первую книгу.");
        }
    }

    private static void askToContinue(Scanner scanner) {
        System.out.print("\nДля продолжения работы нажмите клавишу <Enter>.");
        String answer;
        do {
            answer = scanner.nextLine();
        } while (!answer.isEmpty());
    }
}