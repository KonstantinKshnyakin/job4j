package ru.job4j.condition;

public class StringEq {

    public static boolean check(String login) {
        String root = new String("root");
        return root.equals(login);
    }

    public static void main(String[] args) {
        String your = "your_name";
        boolean access = StringEq.check(your);
        System.out.println(access);
    }
}
