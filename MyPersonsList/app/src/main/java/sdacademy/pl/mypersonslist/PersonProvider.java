package sdacademy.pl.mypersonslist;

import java.util.ArrayList;
import java.util.List;

public class PersonProvider {

    public List<Person> provide() {

        List<Person> result = new ArrayList<>();

//        trzecia wersja

        result.add(new Person("Adrian", 24));
        result.add(new Person("Kasia", 18));

//        druga wersja

        Person person2 = new Person("Arek", 20);
        result.add(person2);

//       pierwsza wersja

        Person person3 = new Person();
        person3.setName("Mateusz");
        person3.setAge(21);

        result.add(person3);

        return result;

    }
}
