package sdacademy.pl.mypersonslist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        PersonProvider provider = new PersonProvider();
        List<Person> persons = provider.provide();

//        cos co jest potrzebne, to zaleznosc

        PersonAdapter personAdapter = new PersonAdapter(persons);

        listView.setAdapter(personAdapter);

    }

    private class PersonAdapter extends BaseAdapter {

        private List<Person> persons;

//        konstruktor, ktory przyjmuje liste

        private PersonAdapter(List<Person> persons) {
            this.persons = persons;
        }

        @Override
        public int getCount() {
            return persons.size();
        }

        @Override
        public Object getItem(int position) {
            return persons.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if(convertView instanceof TextView) {
                textView = (TextView) convertView;
            } else {
                textView = new TextView(MainActivity.this);
            }
            Person person = persons.get(position);

//            wyswietli jak w standardowym toString
//            textView.setText(person.toString());
//            jak chcemy zmodyfikowac zmieniamy tutaj, albo tworzymy osobna klase do modyfikacji Stringow

            textView.setText(person.getName() + ", age: " + person.getAge());
            return textView;
        }
    }
}
