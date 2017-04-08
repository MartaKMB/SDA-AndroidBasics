package sdacademy.pl.mytaxform;

import android.text.Editable;
import android.text.TextWatcher;


public abstract class TextWatcherAdapter implements TextWatcher {

//    klasa stworzona, aby w Main nie pojawialy sie niepotrzebne metody, odnosimy sie wtedy do tej klasy a nie interfejsu

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
