package sdacademy.pl.mypersonslist;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonProviderTest {
    @Test
    public void provide() throws Exception {
        PersonProvider provider = new PersonProvider();
        List<Person> result = provider.provide();
    }

}