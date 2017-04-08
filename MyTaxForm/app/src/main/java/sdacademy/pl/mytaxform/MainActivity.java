package sdacademy.pl.mytaxform;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.renderscript.Double2;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import sdacademy.pl.mytaxform.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private TaxModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ActivityMainBinding powstaje w oparciu o xml - tworzymy obiekt nie przez new

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        towrzymy nowy model

        model = new TaxModel();

//        laczymy dwa powyzsze

        binding.setModel(model);

//        do sprawdzenia  w ta strone jest domyslne, w druga SDK nie ma
//        w druga oznacza z layout'u do logiki
//        model.setAmount(1000);
//        model.setFreeAmount(500);
//        model.setTaxPercentage(10);

//        try {
//            model.setAmount(Double.parseDouble(binding.amountEditText.getText().toString()));
//        } catch (NumberFormatException e) {
//            model.setAmount(0);
//        }
//        model.setFreeAmount(parseField(binding.freeAmountEditText.getText()));


//        wpisujac liczby na biezaco zmiana widoku/wyniku
//        TextWatcher - interfejs, dzialamy poprzez metody, nie przez new

//        uzywamy TextWatcherAdapter

        binding.freeAmountEditText.addTextChangedListener(new TextWatcherAdapter() {

//            po zmianie tekstu wpisujemy wartosc double z tej metody do tego modelu

            @Override
            public void afterTextChanged(Editable editable) {
                model.setFreeAmount(parseField(editable));

            }
        });

        binding.amountEditText.addTextChangedListener(new TextWatcherAdapter() {

            @Override
            public void afterTextChanged(Editable editable) {
                model.setAmount(parseField(editable));
            }
        });

        binding.taxPercentage.addTextChangedListener(new TextWatcherAdapter() {

            @Override
            public void afterTextChanged(Editable editable) {
                model.setTaxPercentage(parseField(editable));
            }
        });

    }

    private double parseField(Editable editable) {
        try {

//            przeniesiewnie wartosci do modelu

            return Double.parseDouble(editable.toString());
        } catch (NumberFormatException e) {

//            zwracanie liczby z pola tekstowego, jak sie nie uda, to 0

            return 0;
        }
    }

}
