package ru.job4j.tracker;


import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.db.SqlTracker;
import ru.job4j.tracker.db.Store;
import ru.job4j.tracker.put.ConsoleInput;
import ru.job4j.tracker.put.Input;
import ru.job4j.tracker.put.ValidateInput;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction());
            actions.add(new ShowAction());
            actions.add(new EditAction());
            actions.add(new FindByIdAction());
            actions.add(new FindByNameAction());
            actions.add(new DeleteAction());
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
