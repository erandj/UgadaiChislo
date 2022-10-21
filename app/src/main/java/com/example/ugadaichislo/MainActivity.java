package com.example.ugadaichislo;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);
        guess = (int)(Math.random()*100);
        gameFinished = false;
    }
    public void onClick(View v){
        if(!gameFinished){
            int number = Integer.parseInt(etInput.getText().toString());
            if (number > guess){
                tvInfo.setText(getResources().getString(R.string.ahead));
            }
            if (number < guess){
                tvInfo.setText(getResources().getString(R.string.behind));
            }
            if (number == guess){
                tvInfo.setText(getResources().getString(R.string.hit));
                gameFinished = true;
            }
        }
        else{
            guess = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            etInput.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }

        etInput.setText("");

    }
}