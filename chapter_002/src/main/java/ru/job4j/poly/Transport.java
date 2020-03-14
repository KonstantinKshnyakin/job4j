package ru.job4j.poly;

public interface Transport {

    void ride();

    void passengers(int quantityPassengers);

    double fillUp(double liters);
}
