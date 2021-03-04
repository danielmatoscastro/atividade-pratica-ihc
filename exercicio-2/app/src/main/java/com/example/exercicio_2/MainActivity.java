package com.example.exercicio_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        EditText et = (EditText) findViewById(R.id.editTextMessage);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", et.getText().toString());

        startActivity(intent);
    }
}