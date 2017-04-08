package sdacademy.pl.mydaggerexample;

import sdacademy.pl.mydaggerexample.model.Army;
import sdacademy.pl.mydaggerexample.model.Building;
import sdacademy.pl.mydaggerexample.model.Economy;
import sdacademy.pl.mydaggerexample.model.Population;
import sdacademy.pl.mydaggerexample.model.State;

public class DependencyResolver {

//    wstrzykujemy konkretne zaleznosci do kontretnych klas
//    recznie, co robi Dagger w metodzie resolve()

    public static State resolve() {

//        tworzymy wszystko, czego potrzebujemy
//        jak zmienimy zaleznosci musimy zmieniac kod
//        im wiecej klad tym bardziej skomplikowany kod, dlatego

        Building building = new Building();
        Population population = new Population();
        Army army = new Army(population);
        Economy economy = new Economy(army, building, population);
        State state = new State(economy);

        return state;
    }
}
