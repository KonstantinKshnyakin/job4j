package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.put.Input;
import ru.job4j.tracker.put.StubInput;
import ru.job4j.tracker.put.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"one", "1"};
        Input input = new StubInput(data);
        ValidateInput validate = new ValidateInput(input);
        validate.askInt("Enter", 5);
        assertThat(
                mem.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(out);
    }

    @Test
    public void whenInvalidNumberInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"6", "1"};
        Input input = new StubInput(data);
        ValidateInput validate = new ValidateInput(input);
        validate.askInt("Enter", 5);
        assertThat(
                mem.toString(),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(out);
    }

    @Test
    public void whenInvalidNumberInput2() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"one", "1"};
        Input input = new StubInput(data);
        ValidateInput validate = new ValidateInput(input);
        validate.askInt("Enter");
        assertThat(
                mem.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(out);
    }
}
