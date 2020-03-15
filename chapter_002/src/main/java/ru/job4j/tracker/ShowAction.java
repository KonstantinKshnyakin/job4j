package ru.job4j.tracker;

public class ShowAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] all = tracker.findAll();
        for (int i = 0; i < all.length; i++) {
            System.out.println(i + ". " + all[i]);
        }
        return true;
    }
}
