package ru.job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter Id: ");
        String newName = input.askStr("Enter new name: ");
        Item item = new Item(newName);
        if (tracker.replace(id, item)) {
            System.out.println("Item edited");
        } else {
            System.out.println("Old item not found");
        }
        return true;
    }
}
