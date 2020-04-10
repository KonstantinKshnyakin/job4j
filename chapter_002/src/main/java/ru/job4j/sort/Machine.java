package ru.job4j.sort;

import java.util.Arrays;

public class Machine {

    private final static int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int change = money - price;
        for (int coin : COINS) {
            while (change - coin >= 0) {
                change -= coin;
                rsl[size] = coin;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}