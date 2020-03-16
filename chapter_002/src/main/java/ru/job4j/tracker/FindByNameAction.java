package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] itemByName = tracker.findByName(name);
        if (itemByName.length != 0) {
            for (int i = 0; i < itemByName.length; i++) {
                System.out.println(itemByName[i]);
            }
        } else {
            System.out.println("Name not found");
        }
        return true;
    }
}
