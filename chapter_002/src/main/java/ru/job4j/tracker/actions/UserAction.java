package ru.job4j.tracker.actions;

import ru.job4j.tracker.db.Store;
import ru.job4j.tracker.put.Input;

public interface UserAction {

    String name();

    boolean execute(Input input, Store tracker);
}
