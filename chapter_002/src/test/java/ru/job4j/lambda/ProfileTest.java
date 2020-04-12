package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProfileTest {
    @Test
    public void collectTest() {
        Address address1 = new Address("Moscow", "Lenina", 22, 14);
        Address address2 = new Address("Saint-Petersburg", "Lenina", 34, 132);
        Address address3 = new Address("Omsk", "Lenina", 46, 71);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        List<Profile> input = Arrays.asList(profile1, profile2, profile3);
        List<Address> expected = Arrays.asList(address1, address2, address3);
        List<Address> rst = Profile.collect(input);
        Assert.assertEquals(expected, rst);
    }
}
