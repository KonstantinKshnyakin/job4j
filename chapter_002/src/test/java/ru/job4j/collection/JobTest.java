package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobTest {

    private final Job bug1 = new Job("Bug", 1);
    private final Job bug4 = new Job("Bug", 4);
    private final Job bug2 = new Job("Bug", 2);
    private final Job task0 = new Job("Task", 0);
    private final List<Job> jobs = Arrays.asList(bug1, bug4, bug2, task0);

    @Test
    public void whenComparatorDescByNameAndDescByPriority() {
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        List<Job> expected = Arrays.asList(task0, bug4, bug2, bug1);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescByNameAndAscByPriority() {
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = Arrays.asList(task0, bug1, bug2, bug4);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Collections.sort(jobs, new JobAscByName().thenComparing(new JobDescByPriority()));
        List<Job> expected = Arrays.asList(bug4, bug2, bug1, task0);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorAscByNameAndAscByPriority() {
        Collections.sort(jobs, new JobAscByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = Arrays.asList(bug1, bug2, bug4, task0);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescBy() {
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(task0, bug1, bug4, bug2);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorAscByName() {
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(bug1, bug4, bug2, task0);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(bug4, bug2, bug1, task0);
        Assert.assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(task0, bug1, bug2, bug4);
        Assert.assertEquals(expected, jobs);
    }
}