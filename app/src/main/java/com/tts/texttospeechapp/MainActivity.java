package com.tts.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button bgConvert,bgClear;
    TextToSpeech textToSpeech;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode());

        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        etInput = (EditText) findViewById(R.id.et_input);
        bgConvert = (Button) findViewById(R.id.bt_convert);
        bgClear = (Button) findViewById(R.id.bt_clear);



        textToSpeech = new TextToSpeech(getApplicationContext()
                , new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
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