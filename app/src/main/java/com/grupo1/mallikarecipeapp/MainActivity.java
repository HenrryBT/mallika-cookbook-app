package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOTD = findViewById(R.id.btn_send_otp);
        Button btnApple = findViewById(R.id.btn_apple_login);
        Button btnFacebook = findViewById(R.id.btn_facebook_login);
        Button btnGoogle = findViewById(R.id.btn_google_login);

        btnOTD.setOnClickListener(this);
        btnApple.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        boolean otp = view.getId() == R.id.btn_send_otp;
        boolean apple = view.getId() == R.id.btn_apple_login;
        boolean facebook = view.getId() == R.id.btn_facebook_login;
        boolean google = view.getId() == R.id.btn_google_login;

        if (otp || apple || facebook || google)
            startActivity(new Intent(this, HomeActivity.class));
    }
}