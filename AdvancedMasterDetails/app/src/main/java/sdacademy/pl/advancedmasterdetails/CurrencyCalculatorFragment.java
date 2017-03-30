package sdacademy.pl.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CurrencyCalculatorFragment extends Fragment {

    private TextView resultCurrency;
    private EditText editTextCurrency;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        metoda inflate wczytuje z pliku

        View view = inflater.inflate(R.layout.fragment_currency_calculator, container, false);

        final EditText editTextCurrency = (EditText) view.findViewById(R.id.editTextCurrency);

        Button buttonCalcCurrency = (Button) view.findViewById(R.id.buttonCalcCurrency);

        resultCurrency = (TextView) view.findViewById(R.id.resultCurrency);

        buttonCalcCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringValue = editTextCurrency.getText().toString();
                try{
                    int value = Integer.parseInt(stringValue);
                    double result = value * 3.75;
                    resultCurrency.setText(Double.toString(result));
                } catch (Exception e) {
                    resultCurrency.setText(R.string.calc_error);
                }

            }
        });

        return view;
    }
}
