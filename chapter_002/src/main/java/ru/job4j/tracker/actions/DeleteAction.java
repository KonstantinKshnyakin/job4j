package ru.job4j.tracker.actions;

import ru.job4j.tracker.db.Store;
import ru.job4j.tracker.put.Input;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        Integer id = input.askInt("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
