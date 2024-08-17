package com.startjava.lesson_2_3.array;

import java.util.Arrays;
import java.util.Scanner;

public class GallowsGame {
    public static void main(String[] args) {
        String[] words = {"ОКНО", "ДВЕРЬ", "ШКАФ", "ЛАМПА", "ПОЛКА", "ГИТАРА"};
        int index = (int) (Math.random() * 5);
        play(words[index]);
    }

    private static void play(String word) {
        System.out.println("Игра \"Виселица\". Угадайте слово или будете повешены!");
        char[] guess = init(word.length());
        printGuess(guess);
        char[] wrongLetters = new char[31];
        int counterEfforts = 0;
        boolean doContinue = true;
        boolean isWin = false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (doContinue) {
              //  printGuess(guess);
              //  showWrongLetters(wrongLetters);
                System.out.print("Введите букву: ");
                char letter = readLetter(scanner);
                while (!checkIfLetter(letter)) {
                    System.out.print("Это не кириллическая буква. Повторите ввод: ");
                    letter = readLetter(scanner);
                }
                if (contains(word.toCharArray(), letter)) {
                    if (!contains(guess, letter)) {
                        guess = addRightLetter(word, guess, letter);
                        if (counterEfforts != 0) {
                            counterEfforts--;
                        }
                        String l = new String(guess);
                        if (word.equals(l)) {
                            isWin = true;
                            break;
                        }
                    } else {
                        System.out.println("Эта буква вводилась ранее. Пожалуйста, повторите ввод.");
                        continue;
                    }
                } else {
                    if (contains(wrongLetters, letter)) {
                        System.out.println("Эта буква вводилась ранее. Пожалуйста, повторите ввод ");
                        continue;
                    } else {
                        System.out.println("Такой буквы в слове нет.");
                        addWrongLetter(wrongLetters, letter);
                        counterEfforts++;
                    }
                }
                printGallows(counterEfforts);
                if (counterEfforts == 6) {
                    doContinue = false;
                } else {
                    System.out.printf("Осталось попыток: %d%n", 6 - counterEfforts);
                }
                System.out.println();
                printGuess(guess);
                showWrongLetters(wrongLetters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showMessage(isWin, word);
    }

    private static char[] init(int length) {
        char[] guess = new char[length];
        Arrays.fill(guess, '*');
        return guess;
    }

    private static void printGuess(char[] guess) {
        System.out.print("Угадайте слово: ");
        for (char symbol : guess) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    private static void printGallows(int step) {
        String[] gallows = {"   ____", "   |   |", "   |   ()", "   |   /|\\",
                "   |   / \\", "  _|_"};
        for (int i = 0; i < step; i++) {
            System.out.println(gallows[i]);
        }
        System.out.println();
    }

    private static boolean contains(char[] symbols, char letter) {
        for (char symbol : symbols) {
            if (symbol == letter) {
                return true;
            }
        }
        return false;
    }

    private static void showMessage(boolean isWin, String word) {
        System.out.printf("Вы " + (isWin ? "выиграли!" : "проиграли! Загаданное слово - " + word));
    }

    private static char[] addRightLetter(String word, char[] guess, char letter) {
        char[] wordLetters = word.toCharArray();
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == letter) {
                guess[i] = letter;
            }
        }
        return guess;
    }

    private static void addWrongLetter(char[] wrongLetters, char letter) {
        if (contains(wrongLetters, letter)) {
            return;
        }
        for(int i = 0; i < wrongLetters.length; i++) {
            if (wrongLetters[i] == 0) {
                wrongLetters[i] = letter;
                break;
            }
        }
    }

    private static void showWrongLetters(char[] wrongLetters) {
        if (wrongLetters[0] != 0) {
            System.out.print("Буквы, которых нет в слове: ");
            for (char letter : wrongLetters) {
                if (letter != 0) {
                    System.out.print(letter + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean checkIfLetter(char letter) {
        if (letter < 'А' || letter > 'Я') {
            return false;
        }
        return true;
    }

    private static char readLetter(Scanner scanner) {
        char letter = scanner.next().charAt(0);
        scanner.nextLine();
        return letter;
    }
}