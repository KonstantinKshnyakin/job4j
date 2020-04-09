package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        CreateAction createAction = new CreateAction();
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        createAction.execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAdd2Item() {
        CreateAction createAction = new CreateAction();
        String[] answers = {"Fix PC", "Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        createAction.execute(input, tracker);
        createAction.execute(input, tracker);
        int length = tracker.findByName("Fix PC").size();
        assertEquals(2, length);
    }

    @Test
    public void whenReplaceItem() {
        EditAction editAction = new EditAction();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(),
                "replaced item"
        };
        editAction.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        DeleteAction deleteAction = new DeleteAction();
        Tracker tracker = new Tracker();
        Item item = new Item("deleted item");
        tracker.add(item);
        String[] answers = {item.getId()};
        deleteAction.execute(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), List.of(action));
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), List.of(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}

