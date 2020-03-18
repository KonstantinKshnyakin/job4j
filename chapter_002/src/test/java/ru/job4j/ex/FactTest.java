package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test
    public void whenCalc5ThenFact120() {
        Fact fact = new Fact();
        int calc = fact.calc(5);
        Assert.assertEquals(120, calc);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalcLessOneThenThrownException() {
        Fact fact = new Fact();
        fact.calc(0);
    }
}
