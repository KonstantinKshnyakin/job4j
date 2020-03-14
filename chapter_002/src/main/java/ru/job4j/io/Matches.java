package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    private final static String message = "Можно взять от 1 до 3 спичек!";
    private static int inputNumber;
    private static int numberMatches;
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        numberMatches = 11;
        int moveCounter = 0;
        System.out.println("Количество спичек : " + numberMatches);
        System.out.println(message);
        while (numberMatches > 0) {
            if (moveCounter % 2 == 0) {
                moveCounter = playerMove(1, moveCounter);
            } else {
                moveCounter = playerMove(2, moveCounter);
            }
            System.out.println("Количество спичек : " + numberMatches);
            if (numberMatches == 0 && moveCounter % 2 == 0) {
                System.out.println("Победил игрок № 1");
            } else if (numberMatches == 0) {
                System.out.println("Победил игрок № 2");
            }
        }
    }

    public static int playerMove(int player, int moveCounter) {
        System.out.println("Ход игрока № " + player);
        inputNumber = Integer.valueOf(input.nextLine( ));
        if (validateInputNumbers(numberMatches)) {
            numberMatches = numberMatches - inputNumber;
            return moveCounter++;
        }
        return moveCounter;
    }

    public static boolean validateInputNumbers(int numberMatches) {
        if (inputNumber >= 1 && inputNumber <= 3) {
            if (numberMatches - inputNumber >= 0){
                return true;
            }
        }
        System.out.println("Невреное колличество спичек!" + System.lineSeparator( ) + message);
        return false;
    }
}
