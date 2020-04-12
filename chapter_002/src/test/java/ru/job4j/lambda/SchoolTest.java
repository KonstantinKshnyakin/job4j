package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SchoolTest {

    private final Student student1 = new Student(35);
    private final Student student2 = new Student(54);
    private final Student student3 = new Student(28);
    private final Student student4 = new Student(68);
    private final Student student5 = new Student(61);
    private final Student student6 = new Student(42);
    private final Student student7 = new Student(79);
    private final Student student8 = new Student(85);
    private final Student student9 = new Student(92);
    private final List<Student> input = Arrays.asList(student1, student2, student3,
            student4, student5, student6, student7, student8, student9);

    @Test
    public void whenScoreLess50() {
        List<Student> collect = School.collect(input, s -> s.getScore() > 0 && s.getScore() < 50);
        List<Student> expected = Arrays.asList(student1, student3, student6);
        Assert.assertEquals(expected, collect);
    }

    @Test
    public void whenScoreMore50AndLess70() {
        List<Student> collect = School.collect(input, s -> s.getScore() >= 50 && s.getScore() < 70);
        List<Student> expected = Arrays.asList(student2, student4, student5);
        Assert.assertEquals(expected, collect);
    }

    @Test
    public void whenScoreMore70() {
        List<Student> collect = School.collect(input, s -> s.getScore() >= 70 && s.getScore() < 100);
        List<Student> expected = Arrays.asList(student7, student8, student9);
        Assert.assertEquals(expected, collect);
    }
}
