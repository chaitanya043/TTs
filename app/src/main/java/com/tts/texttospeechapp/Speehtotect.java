package com.tts.texttospeechapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Speehtotect extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1;


    EditText textTv;
    ImageButton voiceBtn;
    Button clearbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speehtotect);

        textTv = findViewById(R.id.et_input);
        voiceBtn = findViewById(R.id.voiceBtn);
        clearbtn = findViewById(R.id.clear);

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textTv.setText("");

            }
        });

        voiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                speak();

            }
        });

    }

    private void speak() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something...");


        try {

            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);


        } catch (Exception e) {

            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(
                        RecognizerIntent.EXTRA_RESULTS);
                textTv.setText(
                        Objects.requireNonNull(result).get(0));
            }
        }
    }

}
