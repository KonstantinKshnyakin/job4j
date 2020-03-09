package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        double expected = 2;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance2() {
        Point a = new Point(0, 2);
        Point b = new Point(5, 1);
        double out = a.distance(b);
        double expected = 5.09;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3() {
        Point a = new Point(2, 3);
        Point b = new Point(12, 1);
        double out = a.distance(b);
        double expected = 10.19;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void checkDistance3D1() {
        Point a = new Point(1, 2, 7);
        Point b = new Point(8, 1, 2);
        double out = a.distance(b);
        double expected = 7.07;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void checkDistance2() {
        Point a = new Point(2, 12, 15);
        Point b = new Point(8, 1, 0);
        double out = a.distance(b);
        double expected = 12.52;
        Assert.assertEquals(expected, out, 0.01);
    }
}
