package sdacademy.pl.masterdetailexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private TextView title;
    private TextView textDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_layout, container);


        title = (TextView) view.findViewById(R.id.title);
        textDescription = (TextView) view.findViewById(R.id.textDescription);

        return view;

    }

    public void showBasicData() {
        title.setText("Basic Data");
        textDescription.setText("Jan Kowalski");
    }

    public void showDetailsData() {
        title.setText("Details");
        textDescription.setText("Flower Street, Poznan \n age: 41 \n height: 172 cm");
    }
}
