package ru.job4j.pseudo;

import org.junit.Test;
import ru.job4j.stragery.Paint;
import ru.job4j.stragery.Square;
import ru.job4j.stragery.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        String lineSeparator = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+++++++").append(lineSeparator)
                                .append("+     +").append(lineSeparator)
                                .append("+     +").append(lineSeparator)
                                .append("+++++++").append(lineSeparator)
                                .toString()

                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        String lineSeparator = System.lineSeparator();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +   ").append(lineSeparator)
                                .append("  + +  ").append(lineSeparator)
                                .append(" +   + ").append(lineSeparator)
                                .append("+++++++").append(lineSeparator)
                                .toString()

                )
        );
        System.setOut(stdout);
    }
}
