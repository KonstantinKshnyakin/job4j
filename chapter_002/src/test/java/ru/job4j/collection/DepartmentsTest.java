package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    public static final String K1 = "K1";
    public static final String K2 = "K2";
    public static final String K1SK1 = "K1/SK1";
    public static final String K2SK1 = "K2/SK1";
    public static final String K1SK1SSK1 = "K1/SK1/SSK1";
    public static final String K1SK1SSK2 = "K1/SK1/SSK2";
    public static final String K2SK1SSK1 = "K2/SK1/SSK1";
    public static final String K2SK1SSK2 = "K2/SK1/SSK2";

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList(K1SK1);
        List<String> expect = Arrays.asList(K1, K1SK1);
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList(K1, K1SK1);
        List<String> expect = Arrays.asList(K1, K1SK1);
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortAsc() {
        List<String> input = Arrays.asList(K1SK1SSK1, K2SK1SSK1,
                K2, K1SK1, K2SK1SSK2, K1SK1SSK2, K2SK1, K1);
        List<String> expect = Arrays.asList(K1, K1SK1, K1SK1SSK1,
                K1SK1SSK2, K2, K2SK1, K2SK1SSK1, K2SK1SSK2);
        Departments.sortAsc(input);
        assertThat(input, is(expect));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList(K1SK1SSK1, K2SK1SSK1,
                K2, K1SK1, K2SK1SSK2, K1SK1SSK2, K2SK1, K1);
        List<String> expect = Arrays.asList(K2, K2SK1, K2SK1SSK1, K2SK1SSK2,
                K1, K1SK1, K1SK1SSK1, K1SK1SSK2);
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }
}
