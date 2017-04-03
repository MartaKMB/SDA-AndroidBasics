package sdacademy.pl.simplelistofnumbers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(13);
        numbers.add(-7);

        listView.setAdapter(new MyListAdapter(numbers));

        EditText insertNumber = (EditText) findViewById(R.id.insertNumber);

        if(insertNumber != null) {

            String newNumberString = insertNumber.getText().toString();
            Integer newNumber = Integer.parseInt(newNumberString);

            numbers.add(newNumber);

        } else {

            Toast.makeText(MainActivity.this, "Insert number!", Toast.LENGTH_SHORT).show();
        }

    }

    public class MyListAdapter extends BaseAdapter {

        private List<Integer> numbers;

        public MyListAdapter(List<Integer> numbers) {
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
            if(convertView instanceof TextView) {
                textView = (TextView) convertView;
            } else {
                textView = new TextView(MainActivity.this);
            }
            textView.setText(getItem(position).toString());
            return textView;
        }
    }
}
