package sdacademy.pl.mydaggerexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sdacademy.pl.mydaggerexample.model.State;

public class MainActivity extends Activity {

//    symulacja dzialanie budzetu panstwa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculateButton = (Button) findViewById(R.id.calculateButton);
        final TextView goldTextView = (TextView) findViewById(R.id.goldTextView);

//        w Main nie ma kodu ze State - jest w osobnej klasie - wazne, zeby tutaj nie zasmiecac!

        final State state = DependencyResolver.resolve();

        goldTextView.setText(String.valueOf(state.getGold()));

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state.countBalence();
                goldTextView.setText(String.valueOf(state.getGold()));
            }
        });
    }
}
