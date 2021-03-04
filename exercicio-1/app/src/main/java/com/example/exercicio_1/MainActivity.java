package com.example.exercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void somar(View view){
        et1 = (EditText) findViewById(R.id.input1);
        et2 = (EditText) findViewById(R.id.input2);
        result = (TextView) findViewById(R.id.textViewResult);

        double val1 = Double.parseDouble(et1.getText().toString());
        double val2 = Double.parseDouble(et2.getText().toString());

        result.setText(getString(R.string.result) + " " +Double.toString(val1+val2));
    }
}