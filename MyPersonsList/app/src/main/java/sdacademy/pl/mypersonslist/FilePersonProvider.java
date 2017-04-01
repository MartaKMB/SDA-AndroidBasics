package sdacademy.pl.mypersonslist;

import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePersonProvider extends PersonProvider {

//    ta klasa korzysta z zasobow, wiec musimy je dostarczyc

    private final Resources resources;

    public FilePersonProvider(Resources resources) {
        this.resources = resources;
    }

    @Override
    public List<Person> provide() {

//        narzedzie strumienia wejscia

        InputStream inputStream = resources.openRawResource(R.raw.persons);
        Scanner scanner = new Scanner(inputStream);

        List<Person> result = new ArrayList<>();


        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();

            try {
                result.add(parse(nextLine));
            } catch (Exception e) {

            }
        }

        scanner.close();
        return result;
    }

//    zamienianie lini tekstu na dane osobowe

    private Person parse(String line) {
        String[] data = line.split(",");
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        return new Person(name, age);
    }
}
