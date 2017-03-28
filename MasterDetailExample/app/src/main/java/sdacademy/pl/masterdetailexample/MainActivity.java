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

        if(detailFragment != null) {
            detailFragment.showBasicData();
        } else {

//            wyswietlenie nowego okna

            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);

        }

    }

    private DetailFragment getDetailFragment() {
        FragmentManager fm = getFragmentManager();
        return (DetailFragment) fm.findFragmentById(R.id.detailFragment);
    }

    public void showDetailsData() {

        DetailFragment detailFragment = getDetailFragment();

        if(detailFragment != null) {
            detailFragment.showDetailsData();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);

        }

    }
}
