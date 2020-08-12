package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .getAsDouble();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(
                        pupil -> new Tuple(
                                pupil.getName(),
                                pupil.getSubjects().stream()
                                        .mapToInt(Subject::getScore)
                                        .average()
                                        .getAsDouble()
                        )
                )
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(
                        pupil -> new Tuple(
                                pupil.getName(),
                                pupil.getSubjects().stream()
                                        .mapToInt(Subject::getScore)
                                        .sum()
                        )
                )
                .max((t1, t2) -> (int) (t1.getScore() - t2.getScore())).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingInt(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max((t1, t2) -> (int) (t1.getScore() - t2.getScore())).get();
    }
}
