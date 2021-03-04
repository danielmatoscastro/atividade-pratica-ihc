package com.example.exercicio_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(getIntent().getStringExtra("message"));
    }
}