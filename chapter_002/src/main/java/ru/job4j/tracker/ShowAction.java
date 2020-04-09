package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> all = tracker.findAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(i + ". " + all.get(i));
        }
        return true;
    }
}
