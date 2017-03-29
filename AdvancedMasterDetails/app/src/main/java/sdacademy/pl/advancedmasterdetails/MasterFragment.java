package sdacademy.pl.advancedmasterdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final MainActivity activity = (MainActivity) getActivity();

//        ten fragment posiada dany layout

        View view = inflater.inflate(R.layout.fragment_master, container, false);

        Button buttonCurrency = (Button) view.findViewById(R.id.buttonCurrency);
        Button buttonInvestment = (Button) view.findViewById(R.id.buttonInvestment);


        return view;

    }
}
