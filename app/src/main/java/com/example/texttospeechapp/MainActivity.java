package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button bgConvert,bgClear;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.et_input);
        bgConvert = (Button) findViewById(R.id.bt_convert);
        bgClear = (Button) findViewById(R.id.bt_clear);



        textToSpeech = new TextToSpeech(getApplicationContext()
                , new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                String et = etInput.getText().toString();

                if (TextUtils.isEmpty(et)) {

                    Toast.makeText(MainActivity.this, "Please Enter Text...", Toast.LENGTH_SHORT).show();

                }

            }


        });




        bgConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = etInput.getText().toString();

                if (TextUtils.isEmpty(s)){

                    Toast.makeText(MainActivity.this, "Please Enter Text..", Toast.LENGTH_SHORT).show();

                } else {

                    int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);

                }

            }
        });


        bgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etInput.setText("");

            }
        });

    }


}