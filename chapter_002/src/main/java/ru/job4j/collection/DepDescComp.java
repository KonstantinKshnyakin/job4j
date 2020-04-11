package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rst;
        String[] split1 = o1.split("/");
        String[] split2 = o2.split("/");
        int lim = Math.min(split1.length, split2.length);
        for (int i = 0; i < lim; i++) {
            if (i == 0) {
                rst = split2[0].compareTo(split1[0]);
            } else {
                rst = split1[i].compareTo(split2[i]);
            }
            if (rst != 0) {
                return rst;
            }
        }
        return o1.length() - o2.length();
    }
}
