package com.miki.powtorka.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miki.powtorka.R;

public class ViewPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

//        z uzyciem lambd
//        () -> new FragmentTriangle()

        ViewPager viewPager = (ViewPager) inflater.inflate(R.layout.pager_title, container, false);

        viewPager.setAdapter(new MyAdapter(getFragmentManager(), new FragmentFactory() {
            @Override
            public Fragment create() {
                return new FragmentTriangle();
            }
        }, new FragmentFactory() {
            @Override
            public Fragment create() {
                return new FragmentRectangle();
            }
        }, new FragmentFactory() {
            @Override
            public Fragment create() {
                return new FragmentCircle();
            }
        }
        ));

//        gdyby uzyc refleksji kod w tym miejscu moglby wygladac nastepujaco:
//        viewPager.setAdapter(new MyAdapter(getFragmentManager(), FragmentCircle.class, FragmentTriangle.class, itd.
//        refleksja, czyli klasa sama w sobie jest obiektem
//        automagicznie

        return viewPager;
    }

//    wybieramy wersje 13, bo obsluguje wersje domyslna fragmentu

    private class MyAdapter extends FragmentStatePagerAdapter {

//        public static final int NUM_PAGES = 3;

        public final FragmentFactory[] factories;
        private final int[] names = {R.string.triangle, R.string.rectangle, R.string.circle};

        public MyAdapter(FragmentManager fm, FragmentFactory... factories) {
            super(fm);
            this.factories = factories;
        }

//        mamy trzy strony, wiec position to 0, 1 lub 2
//        zwracamy jeden z fragmentow

        @Override
        public Fragment getItem(int position) {

//            w zaleznosci od pozycji wykonujemy inna akcje

            return factories[position].create();

//            if (position == 0) {
//                return new FragmentCircle();
//            }
//            if (position == 1) {
//                return new FragmentRectangle();
//            }
//                return new FragmentTriangle();
        }

        @Override
        public int getCount() {

            return factories.length;

//            return NUM_PAGES;

        }

        //    dodawanie tytulow

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(names[position]);
        }
    }

//    mozliwosc wykorzystania tej klasy wielokrotnie
//    ulatwia reuzywanie kodu

    public interface FragmentFactory {
        Fragment create();
    }


}
