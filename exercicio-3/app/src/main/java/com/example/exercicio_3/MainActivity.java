package com.example.exercicio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private final float LIMIAR = 5;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private EditText etx;
    private EditText ety;
    private EditText etz;

    private float[] oldValues = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        etx = (EditText) findViewById(R.id.editTextX);
        ety = (EditText) findViewById(R.id.editTextY);
        etz = (EditText) findViewById(R.id.editTextZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            etx.setText(Float.toString(event.values[0]));
            ety.setText(Float.toString(event.values[1]));
            etz.setText(Float.toString(event.values[2]));
        }


        callNextActivityIfShould(event);

        oldValues = event.values.clone();
    }

    private void callNextActivityIfShould(SensorEvent event) {
        String[] sensors = {"X", "Y", "Z"};
        if (oldValues != null) {
            for (int i = 0; i < 3; i++) {
                if (Math.abs(event.values[i] - oldValues[i]) >= LIMIAR) {
                    callNextActivity(sensors[i], oldValues[i], event.values[i]);
                }
            }
        }
    }

    private void callNextActivity(String sensor, float oldValue, float newValue) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "Você está aqui porque " + sensor + " mudou " + oldValue + " para " +
                newValue;
        intent.putExtra("message", message);

        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}