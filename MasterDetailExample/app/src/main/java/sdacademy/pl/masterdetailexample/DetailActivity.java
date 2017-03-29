package sdacademy.pl.masterdetailexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class DetailActivity extends Activity {

//    forma interfejsu, pod nazwami wartosci

    public static final int BASIC_DATA = 0;
    public static final int DETAILS = 1;
    public static final String TO_SHOW = "TO_SHOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        odbieranie nowej aktywnosci z MainActivity

        int toShow = getIntent().getIntExtra(TO_SHOW, BASIC_DATA);

        if(toShow == BASIC_DATA) {
            getDetailFragment().showBasicData();
        } else if (toShow == DETAILS){
            getDetailFragment().showDetailsData();
        }

    }

    private DetailFragment getDetailFragment() {
        FragmentManager fm = getFragmentManager();
        return (DetailFragment) fm.findFragmentById(R.id.detailFragment);
    }
}
