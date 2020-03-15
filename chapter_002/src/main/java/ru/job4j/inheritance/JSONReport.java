package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        String lineSeparator = System.lineSeparator();
        return "{" + lineSeparator + "name : " + name + "," + lineSeparator + "body : " + body + lineSeparator + "}";
    }
}
