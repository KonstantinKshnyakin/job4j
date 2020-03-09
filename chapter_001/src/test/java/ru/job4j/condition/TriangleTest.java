package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenExist() {
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        assertThat(result, is(true));
    }

    @Test
    public void whenDontExist() {
        boolean result = Triangle.exist(2.0, 2.0, 4.1);
        assertThat(result, is(false));
    }

    @Test
    public void area1() {
        Triangle triangle = new Triangle(new Point(1, 2), new Point(6, 4), new Point(5, 9));
        double area = triangle.area();
        assertEquals(area, 13.5, 0.1);
    }

    @Test
    public void area2() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(8, 2), new Point(3, 6));
        double area = triangle.area();
        assertEquals(area, 21, 0.1);
    }
}
