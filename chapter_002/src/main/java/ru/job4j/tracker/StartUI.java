package ru.job4j.tracker;


public class StartUI {


    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new EditAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new DeleteAction()
        };
        new StartUI().init(input, tracker, actions);
    }
//
//    private static String select = "Select: ";
//    private static String enterName = "Enter name: ";
//    private static String enterId = "Enter Id: ";
//
//    public void init(Input input, Tracker tracker) {
//        boolean run = true;
//        while (run) {
//            this.showMenu();
//            int selectNumber = input.askInt(select);
//            if (selectNumber == 0) {
//                createItem(input, tracker);
//            } else if (selectNumber == 1) {
//                showAll(tracker);
//            } else if (selectNumber == 2) {
//                editItem(input, tracker);
//            } else if (selectNumber == 3) {
//                delete(input, tracker);
//            } else if (selectNumber == 4) {
//                findItemById(input, tracker);
//            } else if (selectNumber == 5) {
//                findItemByName(input, tracker);
//            } else if (selectNumber == 6) {
//                run = false;
//            }
//        }
//    }
//
//    private void showMenu() {
//        System.out.println("Menu.");
//        StringBuilder sb = new StringBuilder();
//        String lineSeparator = System.lineSeparator();
//        sb.append("0. Add new Item").append(lineSeparator);
//        sb.append("1. Show all items").append(lineSeparator);
//        sb.append("2. Edit item").append(lineSeparator);
//        sb.append("3. Delete item").append(lineSeparator);
//        sb.append("4. Find item by Id").append(lineSeparator);
//        sb.append("5. Find items by name").append(lineSeparator);
//        sb.append("6. Exit Program");
//        System.out.println(sb);
//    }
//
//    public static void main(String[] args) {
//        Input input = new ConsoleInput();
//        Tracker tracker = new Tracker();
//        new StartUI().init(input, tracker);
//    }
//
//    public static void findItemByName(Input input, Tracker tracker) {
//        System.out.println("=== Find items by name ====");
//        String name = input.askStr(enterName);
//        Item[] itemByName = tracker.findByName(name);
//        if (itemByName[0] != null) {
//            for (int i = 0; i < itemByName.length; i++) {
//                System.out.println(itemByName[i]);
//            }
//        } else {
//            System.out.println("Name not found");
//        }
//    }
//
//    public static void findItemById(Input input, Tracker tracker) {
//        System.out.println("=== Find item by Id ====");
//        String id = input.askStr(enterId);
//        Item itemById = tracker.findById(id);
//        if (itemById != null) {
//            System.out.println(itemById);
//        } else {
//            System.out.println("Item not found");
//        }
//    }
//
//    public static void editItem(Input input, Tracker tracker) {
//        System.out.println("=== Edit item ====");
//        String id = input.askStr("Enter Id: ");
//        String newName = input.askStr("Enter new name: ");
//        Item item = new Item(newName);
//        if (tracker.replace(id, item)) {
//            System.out.println("Item edited");
//        } else {
//            System.out.println("Old item not found");
//        }
//    }
//
//    public static void delete(Input input, Tracker tracker) {
//        System.out.println("=== Delete item ====");
//        String id = input.askStr(enterId);
//        if (tracker.delete(id)) {
//            System.out.println("Item deleted");
//        } else {
//            System.out.println("Item not found");
//        }
//    }
//
//    public static void createItem(Input input, Tracker tracker) {
//        System.out.println("=== Create a new Item ====");
//        String name = input.askStr(enterName);
//        Item item = new Item(name);
//        tracker.add(item);
//    }
//
//    public static void showAll(Tracker tracker) {
//        System.out.println("=== Show all items ====");
//        Item[] all = tracker.findAll();
//        for (int i = 0; i < all.length; i++) {
//            System.out.println(i + ". " + all[i]);
//        }
//    }
}
