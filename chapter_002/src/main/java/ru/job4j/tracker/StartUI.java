package ru.job4j.tracker;


public class StartUI {

    private static String select = "Select: ";
    private static String enterName = "Enter name: ";
    private static String enterId = "Enter Id: ";

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu( );
            int selectNumber = input.askInt(select);
            if (selectNumber == 0) {
                createItem(input, tracker);
            } else if (selectNumber == 1) {
                showAll(tracker);
            } else if (selectNumber == 2) {
                editItem(input, tracker);
            } else if (selectNumber == 3) {
                delete(input, tracker);
            } else if (selectNumber == 4) {
                findItemById(input, tracker);
            } else if (selectNumber == 5) {
                findItemByName(input, tracker);
            } else if (selectNumber == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println(
                "0. Add new Item" + System.lineSeparator() +
                        "1. Show all items" + System.lineSeparator() +
                        "2. Edit item" + System.lineSeparator() +
                        "3. Delete item" + System.lineSeparator() +
                        "4. Find item by Id" + System.lineSeparator() +
                        "5. Find items by name" + System.lineSeparator() +
                        "6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    private static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr(enterName);
        Item[] itemByName = tracker.findByName(name);
        if (itemByName[0] != null) {
            for (int i = 0; i < itemByName.length; i++) {
                System.out.println(itemByName[i]);
            }
        } else {
            System.out.println("Name not found");
        }
    }

    private static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr(enterId);
        Item itemById = tracker.findById(id);
        if (itemById != null) {
            System.out.println(itemById);
        } else {
            System.out.println("Item not found");
        }
    }

    private static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter old Id: ");
        String newName = input.askStr("Enter new name: ");
        Item item = new Item(newName);
        if (tracker.replace(id, item)) {
            System.out.println("Item edited");
        } else {
            System.out.println("Old item not found");
        }
    }

    private static void delete(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr(enterId);
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Item not found");
        }
    }

    private static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr(enterName);
        Item item = new Item(name);
        tracker.add(item);
    }

    private static void showAll(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] all = tracker.findAll( );
        for (int i = 0; i < all.length; i++) {
            System.out.println(i + ". " + all[i]);
        }
    }
}
