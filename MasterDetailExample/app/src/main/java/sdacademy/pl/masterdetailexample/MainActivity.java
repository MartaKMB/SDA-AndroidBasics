package sdacademy.pl.masterdetailexample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
    }

    public void showBasicData() {

        FragmentManager fm = getFragmentManager();
        DetailFragment detailFragment = (DetailFragment) fm.findFragmentById(R.id.detailFragment);

//        odniesienie do DetailFragment

        detailFragment.showBasicData();

    }
}
