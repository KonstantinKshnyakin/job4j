package ru.job4j.calculator;

public class MathFunc {

    public static int func1(int number) {
        return number * number + 1;
    }

    public static int func2(int number) {
        return number * 10;
    }

    public static void main(String[] args) {
        int result1 = MathFunc.func1(3);
        int result2 = MathFunc.func1(5);
        int total = result1 + result2;
        System.out.println(total);
    }
}
