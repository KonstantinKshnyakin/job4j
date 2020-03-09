package ru.job4j.condition;

public class Triangle {

    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ab, Point bc, Point cd) {
        this.first = ab;
        this.second = bc;
        this.third = cd;
    }


    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    public static boolean exist(double ab, double ac, double bc) {
        return ((ab + ac > bc) && (ac + bc > ab) && (ab + bc > ac));
    }
}
