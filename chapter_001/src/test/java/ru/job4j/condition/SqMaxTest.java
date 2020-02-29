package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        int result = SqMax.max(12, 4, 7, 5);
        assertThat(result, is(12));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(6, 14, 7, 5);
        assertThat(result, is(14));
    }

    @Test
    public void whenThirdMax() {
        int result = SqMax.max(6, 4, 7, 5);
        assertThat(result, is(7));
    }

    @Test
    public void whenForthMax() {
        int result = SqMax.max(6, 4, 7, 15);
        assertThat(result, is(15));
    }
}
