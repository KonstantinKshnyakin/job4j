package ru.job4j.other;

import ru.job4j.other.Pacient;
import ru.job4j.other.Profession;
import ru.job4j.other.Recipe;
import ru.job4j.tracker.Diagnose;

public class Doctor extends Profession {

    private boolean license;
    private int experience;

    public boolean isLicense() {
        return license;
    }

    public int getExperience() {
        return experience;
    }

    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }

    public Recipe getRecipe(String complaints) {
        return new Recipe();
    }
}
