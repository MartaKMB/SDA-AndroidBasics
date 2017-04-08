package sdacademy.pl.mydaggerexample.model;

import javax.inject.Inject;

public class State {

    private final Economy economy;
    private int gold = 1000;

//    zaznaczamy, ze jest to konstruktor wstrzykiwalny

    @Inject
    public State(Economy economy) {
        this.economy = economy;
    }

    public void countBalence() {
        gold -= economy.countCost();
        gold += economy.countGain();

    }

    public int getGold() {
        return gold;
    }
}
