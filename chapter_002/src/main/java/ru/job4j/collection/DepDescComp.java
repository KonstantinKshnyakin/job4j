package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] split1 = o1.split("/");
        String[] split2 = o2.split("/");
        if (split1.length != split2.length) {
            return o1.length() - o2.length();
        }
        int rst1 = split2[0].compareTo(split1[0]);
        int rst2 = split1[1].compareTo(split2[1]);
        int rst3 = split1[2].compareTo(split2[2]);
        if (rst1 == 1) {
            return rst1;
        } else if (rst2 == 1){
            return rst2;
        }
        return rst3;
    }
}
