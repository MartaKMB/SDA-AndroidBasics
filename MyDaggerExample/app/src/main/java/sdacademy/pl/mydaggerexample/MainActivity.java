package sdacademy.pl.mydaggerexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sdacademy.pl.mydaggerexample.dagger.DaggerStateComponent;
import sdacademy.pl.mydaggerexample.dagger.StateComponent;
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
//        bez Dagger'a
//        final State state = DependencyResolver.resolve();

//        z Dagger'em

        final StateComponent stateComponent = DaggerStateComponent.create();
        final State state = stateComponent.state();

//        nie mozna stworzyc drugiego State, ale mozemy swtorzyc drugi komponent
//        final State state2 = stateComponent.state();
//        final State state = stateComponent2.state();

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
