package sdacademy.pl.masterdetailexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        na 1szym widoku juz cos jest na wstepie
//        showBasicData();
    }

    public void showBasicData() {

        DetailFragment detailFragment = getDetailFragment();

//        odniesienie do DetailFragment

//        sprawdzamy - dostosowanie do roznych widokow

        if(detailFragment != null && detailFragment.isInLayout()) {

//            jezeli da sie wyswietlic cos na tym samym widoku

            detailFragment.showBasicData();
        } else {

//            wyswietlenie nowego okna

            Intent intent = new Intent(this, DetailActivity.class);

//            uruchamianie nowej aktywnosci, wiec nadajemy jej nazwe - uzywamy do tego intent
//            przesylanie a odbieranie w DetailActivity

            intent.putExtra(DetailActivity.TO_SHOW, DetailActivity.BASIC_DATA);

            startActivity(intent);

        }

    }

    public void showDetailsData() {

        DetailFragment detailFragment = getDetailFragment();

        if(detailFragment != null && detailFragment.isInLayout()) {
            detailFragment.showDetailsData();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);

            intent.putExtra(DetailActivity.TO_SHOW, DetailActivity.DETAILS);

            startActivity(intent);

        }

    }

    private DetailFragment getDetailFragment() {
        FragmentManager fm = getFragmentManager();
        return (DetailFragment) fm.findFragmentById(R.id.detailFragment);
    }
}
