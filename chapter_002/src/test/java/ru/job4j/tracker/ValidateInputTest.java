package ru.job4j.tracker;

import org.junit.Test;

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
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter", 5);
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
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter", 5);
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
        String[] data = {"5", "1"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter", 3);
        assertThat(
                mem.toString(),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(out);
    }
}
