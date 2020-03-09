package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax19To7Then19() {
        int result = Max.max(19, 7);
        assertThat(result, is(19));
    }

    @Test
    public void whenMax5To5Then5() {
        int result = Max.max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax5And7And12Then12() {
        int result = Max.max(5, 7, 12);
        assertThat(result, is(12));
    }

    @Test
    public void whenMax4And12And17Then17() {
        int result = Max.max(4, 17, 12);
        assertThat(result, is(17));
    }

    @Test
    public void whenMax1And3And7And9Then9() {
        int result = Max.max(1, 3, 7, 9);
        assertThat(result, is(9));
    }

    @Test
    public void whenMax3And4And12And22Then17() {
        int result = Max.max(3, 4, 12, 22);
        assertThat(result, is(22));
    }
}