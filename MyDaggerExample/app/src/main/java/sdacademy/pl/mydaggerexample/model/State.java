package sdacademy.pl.mydaggerexample.model;

public class State {

    private final Economy economy;
    private int gold = 1000;

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
