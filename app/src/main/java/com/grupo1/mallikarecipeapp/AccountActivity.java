package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Button btnProfile = findViewById(R.id.btn_profile_account);
        Button btnBack = findViewById(R.id.btn_back_account);
        Button btnLiked = findViewById(R.id.btn_facebook_login);

        btnProfile.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnLiked.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_profile_account)
            startActivity(new Intent(this, ProfileActivity.class));
        else if (view.getId() == R.id.btn_back_account)
            startActivity(new Intent(this, HomeActivity.class));
        else if (view.getId() == R.id.btn_facebook_login)
            startActivity(new Intent(this, LikeActivity.class));
    }
}