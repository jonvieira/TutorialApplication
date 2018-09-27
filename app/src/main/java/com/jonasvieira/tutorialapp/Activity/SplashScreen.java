package com.jonasvieira.tutorialapp.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jonasvieira.tutorialapp.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(() -> mostrarMainActivity(), 3000);
    }

    private void mostrarMainActivity() {
        startActivity(new Intent(SplashScreen.this, MainActivity.class));
        finish();
    }
}
