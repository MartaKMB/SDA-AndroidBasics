package sdacademy.pl.mydaggerexample.model;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Building {

    @Inject
    public Building() {
    }

    public int countCost() {
        return 100;
    }

    public int countProduction() {
        return 1000;
    }
}
