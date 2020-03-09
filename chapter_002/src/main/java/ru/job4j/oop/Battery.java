package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery powerbank = new Battery(2000);
        Battery mobile = new Battery(300);
        System.out.println("mobile battery: " + mobile.load + ". Powerbank: " + powerbank.load);
        mobile.exchange(powerbank);
        System.out.println("mobile battery: " + mobile.load + ". Powerbank: " + powerbank.load);
    }
}
