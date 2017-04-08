package sdacademy.pl.mydaggerexample.model;

import javax.inject.Inject;

public class Population {

    private int count = 1000;

    @Inject
    public Population() {
    }

    public int countTaxes() {
        return count/10;
    }

    public int getCount() {
        return count;
    }
}
