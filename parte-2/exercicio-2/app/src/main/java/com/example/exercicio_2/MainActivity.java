package com.example.exercicio_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    private Sensor humidity;
    TextView lightValue;
    TextView humidityValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView)findViewById(R.id.light);
        humidityValue = (TextView)findViewById(R.id.humidity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        humidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
            lightValue.setText("Change the light intensity to see the sensor value.");
        }
        else
        {
            lightValue.setText("Light sensor not supported");
        }

        if(humidity != null)
        {
            sensorManager.registerListener(MainActivity.this, humidity,
                    SensorManager.SENSOR_DELAY_NORMAL);
            humidityValue.setText("Change the relative humidity to see the sensor value.");
        }
        else
        {
            humidityValue.setText("Relative humidity sensor not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Light Intensity: " + event.values[0]);
        }
        if(sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY)
        {
            humidityValue.setText("Relative Humidity: " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}