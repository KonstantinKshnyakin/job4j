package ru.job4j.tracker.put;

public interface Input {

    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
