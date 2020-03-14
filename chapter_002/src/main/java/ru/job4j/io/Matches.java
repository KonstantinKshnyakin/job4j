package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    private final static String message = "Можно взять от 1 до 3 спичек!";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberMatches = 11;
        int moveCounter = 0;
        System.out.println("Количество спичек : " + numberMatches);
        System.out.println(message);
        while (numberMatches > 0) {
            int inputNumber;
            if (moveCounter % 2 == 0) {
                System.out.println("Ход игрока № 1");
                inputNumber = Integer.valueOf(input.nextLine( ));
                if (validateInputNumbers(numberMatches, inputNumber)) {
                    numberMatches = numberMatches - inputNumber;
                    moveCounter++;
                }
            } else {
                System.out.println("Ход игрока № 2");
                inputNumber = Integer.valueOf(input.nextLine( ));
                if (validateInputNumbers(numberMatches, inputNumber)) {
                    numberMatches = numberMatches - inputNumber;
                    moveCounter++;
                }
            }
            System.out.println("Количество спичек : " + numberMatches);
            if (numberMatches == 0 && moveCounter % 2 == 0) {
                System.out.println("Победил игрок № 2");
            } else if (numberMatches == 0) {
                System.out.println("Победил игрок № 1");
            }
        }
    }

    public static boolean validateInputNumbers(int numberMatches, int inputNumber) {
        if (inputNumber >= 1 && inputNumber <= 3) {
            if (numberMatches - inputNumber >= 0){
                return true;
            }
        }
        System.out.println("Невреное колличество спичек!" + System.lineSeparator( ) + message);
        return false;
    }
}
