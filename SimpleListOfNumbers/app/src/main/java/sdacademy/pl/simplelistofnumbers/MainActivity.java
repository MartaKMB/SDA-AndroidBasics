package sdacademy.pl.simplelistofnumbers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    EditText editText;
    ListView numbersListView;
    Button addButton;
    TextView maxTextView;
    TextView minTextView;
    TextView meanTextView;

    List<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        numbersListView = (ListView) findViewById(R.id.numbersListView);
        addButton = (Button) findViewById(R.id.addButton);
        maxTextView = (TextView) findViewById(R.id.maxTextView);
        minTextView = (TextView) findViewById(R.id.minTextView);
        meanTextView = (TextView) findViewById(R.id.meanTextView);

        numbers = generateNumbers();

        Collections.sort(numbers);


//        adaptacja listy liczb do widoku

        final NumbersAdapter numbersAdapter = new NumbersAdapter(numbers);
        numbersListView.setAdapter(numbersAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newNumberString = editText.getText().toString();

                try {
                    Integer newNumber = Integer.parseInt(newNumberString);

                    numbers.add(newNumber);

//                    sortujemy

                    Collections.sort(numbers);

                    editText.setText("");

//                    metoda, ktora musi byc wywolana za kazdym razem, jak zmieniamy liste

                    numbersAdapter.notifyDataSetChanged();
                    calculateFields();

                } catch (NumberFormatException e) {
                }
            }
        });

    }

    private void calculateFields() {

        if (numbers.isEmpty()) {
            minTextView.setText("List is empty");
            maxTextView.setText("List is empty");
        } else {
            int minValue = Statistic.minValue(numbers);
            minTextView.setText(String.valueOf(minValue));

            int maxValue = Statistic.maxValue(numbers);
            maxTextView.setText(String.valueOf(maxValue));
        }

        double meanValue = Statistic.avgValue(numbers);
        meanTextView.setText(String.valueOf(meanValue));
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

//        losowo, po dodaniu Random(100) - "ziarno", losowe, ale na stale

        Random random = new Random(100);

        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt(10));
        }

//        numbers.add(2);
//        numbers.add(13);
//        numbers.add(-7);
//        numbers.add(6);

        return numbers;
    }

    public class NumbersAdapter extends BaseAdapter {

        private List<Integer> numbers;

//        konstruktor, zeby nadac listy

        public NumbersAdapter(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int getCount() {
            return numbers.size();
        }

        @Override
        public Object getItem(int position) {
            return numbers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;

//            convertView -pod ta zmienna widok, ktory wyszedl za ekran
//            kod uniwersalny

            if (convertView instanceof TextView) {
                textView = (TextView) convertView;
            } else {
                textView = new TextView(MainActivity.this);
            }
            textView.setText(String.valueOf(numbers.get(position)));
            return textView;
        }
    }
}
