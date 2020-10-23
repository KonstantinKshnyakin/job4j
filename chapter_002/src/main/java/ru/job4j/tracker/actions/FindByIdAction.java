package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.db.Store;
import ru.job4j.tracker.put.Input;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        Integer id = input.askInt("Enter Id: ");
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            System.out.println(itemById);
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
