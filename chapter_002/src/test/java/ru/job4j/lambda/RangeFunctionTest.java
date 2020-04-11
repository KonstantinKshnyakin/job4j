package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class RangeFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = RangeFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = RangeFunction.diapason(1, 4, x -> 2 * Math.pow(x, 2) + 2 * x + 3);
        List<Double> expected = Arrays.asList(7D, 15D, 27D);
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunction() {
        List<Double> result = RangeFunction.diapason(7, 10, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(49D, 64D, 81D);
        Assert.assertThat(result, is(expected));
    }
}
