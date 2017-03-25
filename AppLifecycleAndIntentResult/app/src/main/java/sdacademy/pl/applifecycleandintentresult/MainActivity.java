package sdacademy.pl.applifecycleandintentresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    protected TextView textView;

    @OnClick(R.id.button)
    protected void buttonClicked() {
        Intent intent = new Intent(this, ResultActivity.class);

//        podajemy stala po intent

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

//    aby pobrac dane z poprzedniego widoku
//    reagujemy na wyslany intent

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.hasExtra("resultString")) {
            String returnedString = data.getStringExtra("resultString");
            textView.setText(returnedString);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

//        Toast to mechanizm, ktory ma interfejs z dodatkowymi mechanizmami
//        powiadomienie informacyjne
//        jako pierwszy parametr kontekst, 2gi: tekst ktory chcemy wyswietlic, 3: czas wyswietlenia

        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
    }
}
