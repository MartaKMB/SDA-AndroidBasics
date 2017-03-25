package sdacademy.pl.twolabelsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String LINE_1_CONTENT = "SDA is cool.";
    private static final String LINE_2_CONTENT = "Second click";

//    z uzyciem butter knife
//    Bin do zmiennej pod, dzieki temu nie trzeba findViewById

    @BindView(R.id.line1)
    protected TextView line1;

    @BindView(R.id.line2)
    protected TextView line2;

//    dowiazania do cz. interfejsu graficznego
//    stworzone tylko zmienne - nic nie oznaczaja
//    zeby je powiazac zmienne z widokami findViewById

//    private TextView line1;
//    private TextView line2;

    @BindView(R.id.actionButton)
    protected Button clickButton;

    @BindView(R.id.actionButton2)
    protected Button clickButton2;

    @BindView(R.id.actionButton3)
    protected Button clickButton3;

//    guzik modyfikuje widok

//    private Button clickButton, clickButton2, clickButton3;

//    private int clickCounter;

    @OnClick({R.id.actionButton, R.id.actionButton2, R.id.actionButton3})
    protected void onButtonsClick(View v) {
        if (v instanceof Button) {
            Button rzutowany = (Button) v;

            if (rzutowany == clickButton) {
                line1.setText(LINE_1_CONTENT);
            } else if (rzutowany == clickButton2) {
                line2.setText(LINE_2_CONTENT);
            } else {
                line1.setText(null);
                line2.setText(null);
            }
        }
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){

//        metoda wywwolujaca metode z klasy AppCompatActivity

            super.onCreate(savedInstanceState);

//        R odwolanie do zasobow

            setContentView(R.layout.activity_main);

//        zeby bindowanie zaszlo

            ButterKnife.bind(this);

//        clickCounter = 0;

//        ale mozna tez korzystac z final dla counter i zadeklarowa tutaj,
//        co powoduje ze mozna wejsc do tej klasy i dalej
//        korzystac z obiekty

//      v  powiazanie zmiennych z widokami
//        elementy sa podbindowane

//        line1 = (TextView) findViewById(R.id.line1);
//        line2 = (TextView) findViewById(R.id.line2);

//        podajemy klase, ktora ma obsluzyc ten Listener, ktory jest interfejsem


            //                zabrane po wykorzystaniu w @onClick

/*
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override

//         w informacji po kliknieciu v bedzie wyswietlony v, ktory pokaze ktory zostal klikniety

            public void onClick(View v) {

                clickCounter++;

                if(clickCounter == 1){
                    line1.setText(LINE_1_CONTENT);
            } else if (clickCounter == 2){
                    line2.setText(LINE_2_CONTENT);
                }

            }
            });

//        zmiana, aby dodac nowe buttony

        View.OnClickListener listener = new View.OnClickListener() {
            @Override

//         w informacji po kliknieciu v bedzie wyswietlony v, ktory pokaze ktory zostal klikniety
//         View to elemtent, ktory zostal klikniety


            public void onClick(View v) {

//                czy v jest typu button, bo onClick dziala na metodzie View, wiec onClick dziala na wszystkich widokach

                if(v instanceof Button) {
                    Button rzutowany = (Button) v;

                    if(rzutowany == clickButton) {
                        line1.setText(LINE_1_CONTENT);
                    } else if(rzutowany == clickButton2) {
                        line2.setText(LINE_2_CONTENT);
                    } else {
                        line1.setText(null);
                        line2.setText(null);
                    }
                }
                clickCounter++;

                if(clickCounter == 1){
                    line1.setText(LINE_1_CONTENT);
                } else if (clickCounter == 2){
                    line2.setText(LINE_2_CONTENT);
                }
            }

        };

        clickButton = (Button) findViewById(R.id.actionButton);
        clickButton.setOnClickListener(listener);

        clickButton2 = (Button) findViewById(R.id.actionButton2);
        clickButton2.setOnClickListener(listener);

        clickButton3 = (Button) findViewById(R.id.actionButton3);
        clickButton3.setOnClickListener(listener);
        */
        }
    }
