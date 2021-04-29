package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class ChoiceActivity extends AppCompatActivity {

    TextView tts,stt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        tts = findViewById(R.id.tts);
        stt = findViewById(R.id.stt);

        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChoiceActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}