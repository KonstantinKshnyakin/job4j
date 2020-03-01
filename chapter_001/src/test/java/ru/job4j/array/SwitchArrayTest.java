package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SwitchArrayTest {

    @Test
    public void whenSwap0to3() {
        int[] input = {1, 2, 3, 4};
        int[] expect = {4, 2, 3, 1};
        int[] rsl = SwitchArray.swap(input, 0, input.length - 1);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenSwap1to4() {
        int[] input = {1, 2, 3, 4, 9};
        int[] expect = {1, 9, 3, 4, 2};
        int[] rsl = SwitchArray.swap(input, 1, 4);
        assertThat(rsl, is(expect));
    }

    @Test
    public void whenSwap3to6() {
        int[] input = {1, 2, 3, 4, 7, 3, 12};
        int[] expect = {1, 2, 3, 12, 7, 3, 4};
        int[] rsl = SwitchArray.swap(input, 3, 6);
        assertThat(rsl, is(expect));
    }
}