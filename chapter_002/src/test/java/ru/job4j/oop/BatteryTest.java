package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class BatteryTest {

    @Test
    public void whenExchangeBatteryThen2300() {
        Battery powerbank = new Battery(2000);
        Battery mobile = new Battery(300);
        mobile.exchange(powerbank);
        Assert.assertThat(mobile.getLoad(), is(2300));
    }

    @Test
    public void whenExchangeBatteryThen1600() {
        Battery powerbank = new Battery(1500);
        Battery mobile = new Battery(100);
        mobile.exchange(powerbank);
        Assert.assertThat(mobile.getLoad(), is(1600));
    }
}
