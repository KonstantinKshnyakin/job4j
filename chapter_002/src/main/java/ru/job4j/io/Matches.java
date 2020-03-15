package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    private static String message = "Можно взять от 1 до 3 спичек!";
    private static int inputNumber;
    private static int numberMatches;
    private static int moveCounter;
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        numberMatches = 11;
        moveCounter = 0;
        System.out.println("Количество спичек : " + numberMatches);
        System.out.println(message);
        while (numberMatches > 0) {
            if (moveCounter % 2 == 0) {
                playerMove(1);
            } else {
                playerMove(2);
            }
            System.out.println("Количество спичек : " + numberMatches);
            if (numberMatches == 0 && moveCounter % 2 == 0) {
                System.out.println("Победил игрок № 2");
                input.close();
            } else if (numberMatches == 0) {
                System.out.println("Победил игрок № 1");
                input.close();
            }
        }
    }

    public static void playerMove(int player) {
        System.out.println("Ход игрока № " + player);
        inputNumber = Integer.parseInt(input.nextLine());
        if (validateInputNumbers()) {
            numberMatches = numberMatches - inputNumber;
            moveCounter++;
        }
    }

    public static boolean validateInputNumbers() {
        if (inputNumber >= 1 && inputNumber <= 3) {
            if (numberMatches - inputNumber >= 0) {
                return true;
            }
        }
        System.out.println("Невреное колличество спичек!" + System.lineSeparator() + message);
        return false;
    }
}
