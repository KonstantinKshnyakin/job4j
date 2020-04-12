package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MatrixTest {
    @Test
    public void matrixToListTest() {
        Integer[][] integers = {{1, 2, 5}, {6, 3, 9}, {1, 5, 6}};
        List<Integer> rst = Matrix.matrixToList(integers);
        List<Integer> expected = Arrays.asList(1, 2, 5, 6, 3, 9, 1, 5, 6);
        Assert.assertEquals(expected, rst);
    }
}
