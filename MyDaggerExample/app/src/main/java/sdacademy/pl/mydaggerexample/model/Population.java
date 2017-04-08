package sdacademy.pl.mydaggerexample.model;

public class Population {

    private int count = 1000;

    public int countTaxes() {
        return count/10;
    }

    public int getCount() {
        return count;
    }
}
