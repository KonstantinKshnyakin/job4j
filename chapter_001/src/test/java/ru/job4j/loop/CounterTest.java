package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void sumByEvenBefore2And18() {
        int rsl = Counter.sumByEven(2, 18);
        int expected = 90;
        assertThat(rsl, is(expected));
    }

    @Test
    public void sumByEvenBefore4And9() {
        int rsl = Counter.sumByEven(4, 9);
        int expected = 18;
        assertThat(rsl, is(expected));
    }

    @Test
    public void sumByEvenBefore7And34() {
        int rsl = Counter.sumByEven(7, 34);
        int expected = 294;
        assertThat(rsl, is(expected));
    }
}
