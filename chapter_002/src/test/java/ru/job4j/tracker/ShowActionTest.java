package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.ShowAction;
import ru.job4j.tracker.db.MemTracker;
import ru.job4j.tracker.put.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShowActionTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAction act = new ShowAction();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).add("0. " + item)
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
