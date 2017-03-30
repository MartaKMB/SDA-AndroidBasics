package sdacademy.pl.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InvestmentFragment extends Fragment {

//    wyciaganie raczej w sytuacji, kiedy mamy wiecej niz jedna metode

    private EditText amountEditText;
    private EditText yearsEditText;
    private TextView resultInvestment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_investment, container, false);

        amountEditText = (EditText) view.findViewById(R.id.amountEditText);

        yearsEditText = (EditText) view.findViewById(R.id.yearsEditText);

        Button buttonCalcInvestment = (Button) view.findViewById(R.id.buttonCalcInvestment);

        resultInvestment = (TextView) view.findViewById(R.id.resultInvestment);

        buttonCalcInvestment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double percent = 0.02;

                String stringValueAmount = amountEditText.getText().toString();
                String stringValueYears = yearsEditText.getText().toString();

                try{
                    int amount = Integer.parseInt(stringValueAmount);
                    int years = Integer.parseInt(stringValueYears);

//                    amount*1.02^years - procent skladany

                    double result = amount*Math.pow(percent+1, years);

                    resultInvestment.setText(Double.toString(result));
                } catch (Exception e) {
                    resultInvestment.setText(R.string.calc_error);
                }
            }
        });

        return view;
    }
}
