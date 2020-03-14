package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        String enterName = "Enter name: ";
        while (run) {
            this.showMenu( );
            String select = "Select: ";
            String enterId = "Enter Id: ";
            int selectNumber = input.askInt(select);
            if (selectNumber == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr(enterName);
                Item item = new Item(name);
                tracker.add(item);
            } else if (selectNumber == 1) {
                System.out.println("=== Show all items ====");
                Item[] all = tracker.findAll( );
                for (int i = 0; i < all.length; i++) {
                    System.out.println(i + ". " + all[i]);
                }
            } else if (selectNumber == 2) {
                System.out.println("=== Edit item ====");
                String id = input.askStr("Enter old Id: ");
                String newName = input.askStr("Enter new name: ");
                Item item = new Item(newName);
                if (tracker.replace(id, item)) {
                    System.out.println("Item edited");
                } else {
                    System.out.println("Old item not found");
                }
            } else {
                if (selectNumber == 3) {
                    System.out.println("=== Delete item ====");
                    String id = input.askStr(enterId);
                    if (tracker.delete(id)) {
                        System.out.println("Item deleted");
                    } else {
                        System.out.println("Item not found");
                    }
                } else if (selectNumber == 4) {
                    System.out.println("=== Find item by Id ====");
                    String id = input.askStr(enterId);
                    Item itemById = tracker.findById(id);
                    if (itemById != null) {
                        System.out.println(itemById);
                    } else {
                        System.out.println("Item not found");
                    }
                } else if (selectNumber == 5) {
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
                } else if (selectNumber == 6) {
                    run = false;
                }
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
}
