package sdacademy.pl.masterdetailexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MasterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        final, bo chcemy miec do niej dostep w klasie anonimowej

        final MainActivity activity = (MainActivity) getActivity();

//        oprogramowanie, ze ten fragment posiada ten layout

        View view = inflater.inflate(R.layout.master_layout, container);

//        odwolujemy sie do widoku we frgmencie

        Button buttonBD = (Button) view.findViewById(R.id.buttonBD);

        Button buttonD = (Button) view.findViewById(R.id.buttonD);

//        w nawiasia obiekt klasy anonimowej

        buttonBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                chcemy wyswietlic komunikat/informacje - odniesienie do metody w MainActivity

                activity.showBasicData();

            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}
