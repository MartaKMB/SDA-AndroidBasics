package sdacademy.pl.advancedmasterdetails;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        podmienianie ramki na fragment - budujemy to, co ma sie zadziac po kliknieciu przycisku
//        puste miejsce, na ktore cos wstawiamy dynamicznie

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentFrame, new CurrencyCalculatorFragment());

//        dopiero po commit tranzakcje sie wykonuja, tutaj dopiero zamiana fragmentow

        transaction.commit();
    }
}
