package sdacademy.pl.mydaggerexample.model;

import javax.inject.Inject;

public class Economy {

    private final Army army;
    private final Building building;
    private final Population population;


    @Inject
    public Economy(Army army, Building building, Population population) {
        this.army = army;
        this.building = building;
        this.population = population;
    }


    public int countCost() {
        return army.countCost() + building.countCost();
    }

    public int countGain() {
        return building.countProduction() + population.countTaxes();
    }
}
