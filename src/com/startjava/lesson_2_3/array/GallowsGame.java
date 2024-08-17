package com.startjava.lesson_2_3.array;

import java.util.Arrays;
import java.util.Scanner;

public class GallowsGame {
    public static void main(String[] args) {
        String[] words = {"ОКНО", "ДВЕРЬ", "ШКАФ", "ЛАМПА", "ПОЛКА", "ГИТАРА"};
        play(words[(int) (Math.random() * 5)]);
    }

    private static void play(String riddleWord) {
        System.out.println("Игра \"Виселица\". Угадайте слово или будете повешены!");
        char[] guessWord = init(riddleWord.length());
        char[] wrongLetters = new char[31];
        int counterEfforts = 0;
        boolean isWin = false;
        printGuess(guessWord);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                char letter = readCyrillicLetter(scanner);
                if (contains(guessWord, letter) ||
                        contains(wrongLetters, letter)) {
                    System.out.println("Эта буква вводилась ранее. Пожалуйста, повторите ввод.");
                    continue;
                }
                if (!contains(riddleWord.toCharArray(), letter)) {
                    addWrongLetter(wrongLetters, letter);
                    counterEfforts++;
                } else {
                    addRightLetter(riddleWord, guessWord, letter);
                    if (checkEquals(riddleWord, guessWord)) {
                        isWin = true;
                        break;
                    }
                    if (counterEfforts != 0) {
                        counterEfforts--;
                    }
                }
                printGallows(counterEfforts);
                if (counterEfforts == 6) {
                    break;
                } else {
                    System.out.printf("Осталось попыток: %d%n", 6 - counterEfforts);
                }
                System.out.println();
                printGuess(guessWord);
                printWrongLetters(wrongLetters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showMessage(isWin, riddleWord);
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

    private static char readCyrillicLetter(Scanner scanner) {
        System.out.print("Введите букву: ");
        char letter = readLetter(scanner);
        while (!isCyrillic(letter)) {
            System.out.print("Это не кириллическая заглавная буква. Повторите ввод: ");
            letter = readLetter(scanner);
        }
        return letter;
    }

    private static char readLetter(Scanner scanner) {
        char letter = scanner.next().charAt(0);
        scanner.nextLine();
        return letter;
    }

    private static boolean isCyrillic(char letter) {
        return letter >= 'А' && letter <= 'Я';
    }

    private static boolean contains(char[] symbols, char letter) {
        for (char symbol : symbols) {
            if (symbol == letter) {
                return true;
            }
        }
        return false;
    }

    private static void addRightLetter(String word, char[] guess, char letter) {
        char[] wordLetters = word.toCharArray();
        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == letter) {
                guess[i] = letter;
            }
        }
    }

    private static boolean checkEquals(String word, char[] guessWord) {
        String guess = new String(guessWord);
        return word.equals(guess);
    }

    private static void addWrongLetter(char[] wrongLetters, char letter) {
        System.out.println("Такой буквы в слове нет.");
        for (int i = 0; i < wrongLetters.length; i++) {
            if (wrongLetters[i] == 0) {
                wrongLetters[i] = letter;
                break;
            }
        }
    }

    private static void printGallows(int step) {
        String[] gallows = {"   ____", "   |   |", "   |   ()", "   |   /|\\",
                "   |   / \\", "  _|_"};
        for (int i = 0; i < step; i++) {
            System.out.println(gallows[i]);
        }
        System.out.println();
    }

    private static void printWrongLetters(char[] wrongLetters) {
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

    private static void showMessage(boolean isWin, String word) {
        System.out.printf("Вы " + (isWin ? "выиграли!" : "проиграли! Загаданное слово - " + word));
    }
}