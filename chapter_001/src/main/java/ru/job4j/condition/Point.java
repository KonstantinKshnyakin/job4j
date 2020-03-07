package ru.job4j.condition;

public class Point {

    public static double distance(int x1, int y1, int x2, int y2) {
        int x2MinusX1 = x2 - x1;
        int y2MinusY1 = y2 - y1;
        double powX = Math.pow(x2MinusX1, 2);
        double powY = Math.pow(y2MinusY1, 2);
        return Math.sqrt(powX + powY);
    }

    public static void main(String[] args) {
        double result1 = Point.distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result1);

        double result2 = Point.distance(0, 2, 5, 1);
        System.out.println("result (0, 2) to (5, 1) " + result2);

        double result3 = Point.distance(2, 3, 12, 1);
        System.out.println("result (2, 3) to (12, 1) " + result3);
    }
}
