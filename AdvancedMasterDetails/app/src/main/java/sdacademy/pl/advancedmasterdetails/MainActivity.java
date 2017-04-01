package sdacademy.pl.advancedmasterdetails;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        showCurrencyCalculator();

    }

    public void showCurrencyCalculator() {

        if(findViewById(R.id.fragmentFrame) != null) {
            //        podmienianie ramki na fragment - budujemy to, co ma sie zadziac po kliknieciu przycisku
//        puste miejsce, na ktore cos wstawiamy dynamicznie

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentFrame, new CurrencyCalculatorFragment());

//        dopiero po commit tranzakcje sie wykonuja, tutaj dopiero zamiana fragmentow

            transaction.commit();
        } else {
            Intent intent = new Intent(this, CurrencyCalculatorActivity.class);
            startActivity(intent);
        }


    }

    public void showInvestmentButton() {

        if(findViewById(R.id.fragmentFrame) != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentFrame, new InvestmentFragment());
            transaction.commit();
        } else {
            Intent intent = new Intent(this, InvestmentActivity.class);
            startActivity(intent);
        }



    }
}
