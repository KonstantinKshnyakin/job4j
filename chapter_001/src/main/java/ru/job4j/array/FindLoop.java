package ru.job4j.array;

public class FindLoop {

    public int indexOf(int[] data, int element) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == element) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public static int indexOf(int[] data, int element, int start, int finish) {
        int rst = -1;
        for (int index = start; index <= finish; index++) {
            if (data[index] == element) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
