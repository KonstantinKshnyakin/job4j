package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> itemByName = tracker.findByName(name);
        if (itemByName.size() != 0) {
            for (Item item : itemByName) {
                System.out.println(item);
            }
        } else {
            System.out.println("Name not found");
        }
        return true;
    }
}
