package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void ride() {
        System.out.println("Bus is ride");
    }

    @Override
    public void passengers(int quantityPassengers) {
        System.out.println("Quantity of passengers : ");
    }

    @Override
    public double fillUp(double liters) {
        return 0;
    }
}
