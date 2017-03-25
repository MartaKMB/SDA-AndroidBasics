package sdacademy.pl.accelerometerapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @BindView(R.id.axis_x)
    protected TextView axis_x;

    @BindView(R.id.axis_y)
    protected TextView axis_y;

    @BindView(R.id.axis_z)
    protected TextView axis_z;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        rejestracja activity jako zdolnego do odczytywania polozenia urzadzenia
//        trzeba castowac, wiemy ze to bedzie SensorMenager

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager != null) {

//            dostep do accelerometru

            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

//            wszystkie Listener'y to interfejsy

            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

//    zabezpieczenie przed przejsciem do innego activity

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //    po implementacji SensorEventListener

    @Override
    public void onSensorChanged(SensorEvent event) {

//        sprecyzowanie event. <- values, tutaj od x, y i z, spr ile wartosci jest zwroconych

        axis_x.setText(String.valueOf(event.values[0]));
        axis_y.setText(String.valueOf(event.values[1]));
        axis_z.setText(String.valueOf(event.values[2]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
