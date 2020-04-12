package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream()
                .map(p -> p.address)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Profile{" +
                "address=" + address +
                '}';
    }
}
