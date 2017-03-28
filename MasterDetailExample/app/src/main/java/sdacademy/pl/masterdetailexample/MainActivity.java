package sdacademy.pl.masterdetailexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        na 1szym widoku juz cos jest na wstepie

        showBasicData();
    }

    public void showBasicData() {

        FragmentManager fm = getFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fm.findFragmentById(R.id.detailFragment);

//        odniesienie do DetailFragment

        detailFragment.showBasicData();

    }

    public void showDetailsData() {

        FragmentManager fm = getFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fm.findFragmentById(R.id.detailFragment);
        detailFragment.showDetailsData();

    }
}
