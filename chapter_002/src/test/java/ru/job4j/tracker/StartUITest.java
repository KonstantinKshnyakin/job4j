package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
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
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
        createAction.execute(input, tracker);
        createAction.execute(input, tracker);
        int length = tracker.findByName("Fix PC").size();
        assertEquals(2, length);
    }

    @Test
    public void whenReplaceItem() {
        EditAction editAction = new EditAction();
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
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
        new StartUI().init(input, new MemTracker(), List.of(action));
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
        new StartUI().init(input, new MemTracker(), List.of(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void whenAdd2ItemBd() {
        CreateAction createAction = new CreateAction();
        String[] answers = {"Fix PC", "Fix PC"};
        Input input = new StubInput(answers);
        Store tracker = new SqlTracker();
        tracker.init();
        createAction.execute(input, tracker);
        createAction.execute(input, tracker);
        List<Item> fixList = tracker.findByName("Fix PC");
        int length = fixList.size();
        assertEquals(2, length);
        for (Item item : fixList) {
            tracker.delete(item.getId());
        }

    }

    @Test
    public void whenDeleteItemBd() {
        DeleteAction deleteAction = new DeleteAction();
        Store tracker = new SqlTracker();
        tracker.init();
        Item item = new Item("deleted item");
        tracker.add(item);
        String[] answers = {item.getId()};
        deleteAction.execute(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenReplaceItemBd() {
        EditAction editAction = new EditAction();
        Store tracker = new SqlTracker();
        tracker.init();
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
}

