package com.startjava.lesson_2_3.array;

import java.util.Scanner;

public class HangmanGame {
    private static final String[] gallows = {"   _____",
                                             "   |   |",
                                             "   |  ( )",
                                             "   |  /|\\",
                                             "   |  / \\",
                                             "  _|_"};

    public static void main(String[] args) {
        String[] words = {"ОКНО", "ДВЕРЬ", "ШКАФ", "ЛАМПА", "ПОЛКА", "ГИТАРА", "ЦВЕТОК",
                "ДИВАН", "СТОЛ", "КРЕСЛО", "МАШИНА", "СОЛНЦЕ", "РАДУГА", "ДОЖДЬ"};
        play(words[(int) (Math.random() * words.length)]);
    }

    private static void play(String riddleWord) {
        System.out.println("Игра \"Виселица\". Угадайте слово или будете повешены!");
        String guessWord = init(riddleWord.length());
        String wrongLetters = "";
        int totalEfforts = gallows.length;
        int counterEfforts = 0;
        boolean isWin = false;
        boolean hasEfforts = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!isWin && hasEfforts) {
                System.out.printf("Угадайте слово: %s%n", guessWord);
                printWrongLetters(wrongLetters);
                char letter = inputCyrillicLetter(scanner);
                while (guessWord.contains(Character.toString(letter)) ||
                        wrongLetters.contains(Character.toString(letter))) {
                    System.out.println("Эта буква вводилась ранее. Пожалуйста, повторите ввод.");
                    letter = inputCyrillicLetter(scanner);
                }
                if (!riddleWord.contains(Character.toString(letter))) {
                    wrongLetters = addWrongLetter(wrongLetters, letter);
                    counterEfforts++;
                } else {
                    guessWord = addRightLetter(riddleWord, guessWord, letter);
                    if (riddleWord.equals(guessWord)) {
                        isWin = true;
                    }
                    if (counterEfforts != 0) {
                        counterEfforts--;
                    }
                }
                printGallows(counterEfforts);
                hasEfforts = totalEfforts > counterEfforts;
                System.out.printf("Осталось попыток: %d%n", totalEfforts - counterEfforts);
                System.out.println();
            }
        }
        showFinalMessage(isWin, riddleWord);
    }

    private static String init(int length) {
        return "*".repeat(length);
    }

    private static char inputCyrillicLetter(Scanner scanner) {
        System.out.print("Введите букву: ");
        char letter = inputLetter(scanner);
        while (!isCyrillic(letter)) {
            System.out.print("Это не кириллическая заглавная буква. Повторите ввод: ");
            letter = inputLetter(scanner);
        }
        return letter;
    }

    private static char inputLetter(Scanner scanner) {
        return scanner.nextLine().charAt(0);
    }

    private static boolean isCyrillic(char letter) {
        return letter >= 'А' && letter <= 'Я';
    }

    private static String addRightLetter(String riddleWord, String guessWord, char letter) {
        for (int i = 0; i < riddleWord.length(); i++) {
            if (riddleWord.charAt(i) == letter) {
                guessWord = guessWord.substring(0,i) + letter + guessWord.substring(i + 1);
            }
        }
        return guessWord;
    }

    private static String addWrongLetter(String wrongLetters, char letter) {
        System.out.println("Такой буквы в слове нет.");
        return new StringBuilder(wrongLetters).append(letter).append(" ").toString();
    }

    private static void printGallows(int step) {
        for (int i = 0; i < step; i++) {
            System.out.println(gallows[i]);
        }
        System.out.println();
    }

    private static void printWrongLetters(String wrongLetters) {
        if (!wrongLetters.isEmpty()) {
            System.out.printf("Буквы, которых нет в слове: %s%n", wrongLetters);
        }
    }

    private static void showFinalMessage(boolean isWin, String word) {
        System.out.printf("Вы " + (isWin ? "выиграли!" : "проиграли! Загаданное слово - " + word));
    }
}