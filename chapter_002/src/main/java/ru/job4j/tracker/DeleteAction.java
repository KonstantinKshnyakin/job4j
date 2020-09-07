package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
