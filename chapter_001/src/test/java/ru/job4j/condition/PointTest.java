package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        double expected = 2;
        double out = Point.distance(0, 0, 2, 0);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance2() {
        double expected = 5.09;
        double out = Point.distance(0, 2, 5, 1);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3() {
        double expected = 10.19;
        double out = Point.distance(2, 3, 12, 1);
        Assert.assertEquals(expected, out, 0.01);
    }
}
