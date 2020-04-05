package ru.job4j.array;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        if (left.length == 0) {
            return right;
        } else if (right.length == 0) {
            return left;
        }

        for (int i = 0, iLeft = 0, iRight = 0; i < rsl.length; i++) {
            if (iLeft == left.length) {
                System.arraycopy(right, iRight, rsl, i, right.length - iRight);
                break;
            }
            if (iRight == right.length) {
                System.arraycopy(left, iLeft, rsl, i, left.length - iLeft);
                break;
            }
            rsl[i] = left[iLeft] < right[iRight] ? left[iLeft++] : right[iRight++];
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
