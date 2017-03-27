package sdacademy.pl.fragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button button = new Button(getActivity());
        button.setText("OK");

//        ponizsze tutaj, a nie w MainActivity

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                wiem, co zwraca metoda, wiec rzutujemy

                MainActivity activity = (MainActivity) getActivity();
                activity.showToast();
            }
        });
        return button;
    }
}
