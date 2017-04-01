package sdacademy.pl.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final MainActivity activity = (MainActivity) getActivity();

//        ten fragment posiada dany layout

        View view = inflater.inflate(R.layout.fragment_master, container, false);

        final Button buttonCurrency = (Button) view.findViewById(R.id.buttonCurrency);
        Button buttonInvestment = (Button) view.findViewById(R.id.buttonInvestment);


        buttonCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                klasa anonimowa, typ onClick znajduje sie wewnatrz klasy

                activity.showCurrencyCalculator();

//                wczytanie z animacja
//                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.simple_anim);
//                buttonCurrency.startAnimation(animation);

            }
        });

        buttonInvestment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showInvestmentButton();
            }
        });


        return view;

    }
}
