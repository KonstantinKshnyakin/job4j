package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] all = tracker.findAll( );
                for (int i = 0; i < all.length; i++) {
                    System.out.println(i + ". " + all[i]);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter old Id: ");
                String id = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                Item item = new Item(newName);
                if (tracker.replace(id, item)){
                    System.out.println("Item edited");
                } else {
                    System.out.println("Old item not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter Id: ");
                String id = scanner.nextLine();
                if (tracker.delete(id)){
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter Id: ");
                String id = scanner.nextLine();
                Item itemById = tracker.findById(id);
                if (itemById != null){
                    System.out.println(itemById);
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] itemByName = tracker.findByName(name);
                if (itemByName[0] != null){
                    for (int i = 0; i < itemByName.length; i++) {
                        System.out.println(itemByName[i]);
                    }
                } else {
                    System.out.println("Name not found");
                }
            } else if (select == 6) {
                run = false;
                scanner.close();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

    }
}
