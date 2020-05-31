package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private Integer score;
    private String lastName;

    public Student(int score) {
        this.score = score;
    }

    public Student(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return o.score.compareTo(this.score);
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", lastName='" + lastName + '\''
                + '}';
    }
}
