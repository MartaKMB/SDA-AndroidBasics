package sdacademy.pl.gradlezadanie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ArrayMath;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textField);

        int[] numbers = {1, 2, 32, 14, 2};

//        textView.setText(ArrayMath.max(numbers));

//        powyzsze szuka id danej liczby a nie String: 32
//        identyfikator zasobow, aby zamienic to na text:

        textView.setText(Integer.toString(ArrayMath.max(numbers)));


    }
}
