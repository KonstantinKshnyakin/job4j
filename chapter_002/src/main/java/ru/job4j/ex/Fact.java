package ru.job4j.ex;

public class Fact {

    public static void main(String[] args) {
        Fact fact = new Fact();
        fact.calc(1);
    }

    public int calc(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("The number must be greater than or equal to one.");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
