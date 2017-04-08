package sdacademy.pl.mydaggerexample.model;

import javax.inject.Inject;
import javax.inject.Singleton;

//   ta klasa ma byc traktowana, jako Singleton
//  to tylko informacja, jak uzywac tego kodu

@Singleton
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
