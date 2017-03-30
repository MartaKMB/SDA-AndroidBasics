package sdacademy.pl.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class InvestmentFragment extends Fragment {

    private TextView resultInvestment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_investment, container, false);

        Button buttonCalcInvestment = (Button) view.findViewById(R.id.buttonCalcInvestment);

        resultInvestment = (TextView) view.findViewById(R.id.resultInvestment);

//        buttonCalcInvestment.hasOnClickListeners(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
////                resultInvestment.setText("test investment");
//            }
//        });

        return view;
    }
}
