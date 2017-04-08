package sdacademy.pl.myuserdatabinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sdacademy.pl.myuserdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        po zmianach w xml <layout> i w build.gradle dataBinding, mamy dostep do klasy ActivityMainBinding
//        obiekt, ktory jest odpowiedzialny za caly mechanizm
//        korzystamy z metod statycznych tej klasy - wywolanie w sposob statyczny i dodanie this'a jako parametr
//        zamiast zwyklego inflate taka nakladka
//        metoda ogolna, ale nie wymaga rzutowania

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        nie musimy pol deklarowac - dostajemy sie do nich po kropce
//        binding.textView.setText("Test text");
//        pola tworzymny w layout <data> i <variable> i dzieki temu np setUser

        final User user = new User("Jan", "Kowalski");
        binding.setUser(user);

//        w xml'u trzeba zadeklarowac, jak to wyswietlic:
//        android:text="@{user.lastName}"

        binding.changeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                User user2 = new User("Marta", "M-B");
//                binding.setUser(user2);

//                po ponizszej zmianie przycisk nie zadziala - zmiana w klasie User, ale nie informujemy xml'a
//                zeby zadzialalo musimy uczynic User'a obserwowanym, rozszerzenie klasy o BaseObservable
                user.setFirstName("Adam");
                user.setLastName("Nowak");
            }
        });

    }
}
