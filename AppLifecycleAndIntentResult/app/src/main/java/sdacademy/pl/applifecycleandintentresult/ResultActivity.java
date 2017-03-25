package sdacademy.pl.applifecycleandintentresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    protected EditText editText;

    @OnClick(R.id.buttonFinish)
    protected void finishClicked() {

//        po kliknieciu button'a wywolujemy MainActivity
//        intent powrotny

        Intent returnIntent = new Intent();

//        wszystkie extra's to HashMapa, wiec 1sza wartosc musi byc Stringiem
//        to intent powrotny

//        umieszczamy dodatkowe informacje (zawartosc text fielda)

        returnIntent.putExtra("resultString", editText.getText().toString());

//        ustawiamy status

//        zwracana zawartosc

        setResult(RESULT_OK, returnIntent);

//        zamkniecie tego activity, powraca do wywolujacego

        finish();;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
    }
}
