package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.grupo1.mallikarecipeapp.fragments.Receta1Fragment;
import com.grupo1.mallikarecipeapp.fragments.Receta2Fragment;
import com.grupo1.mallikarecipeapp.fragments.Receta3Fragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RadioButton rbReceta1 = findViewById(R.id.rbReceta1);
        RadioButton rbReceta2 = findViewById(R.id.rbReceta2);
        RadioButton rbReceta3 = findViewById(R.id.rbReceta3);
        Button btnAccount = findViewById(R.id.btn_profile_home);

        rbReceta1.setOnClickListener(this);
        rbReceta2.setOnClickListener(this);
        rbReceta3.setOnClickListener(this);
        btnAccount.setOnClickListener(this);

        rbReceta1.setChecked(true);
        mostrarReceta1();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbReceta1:
                mostrarReceta1();
                break;
            case R.id.rbReceta2:
                mostrarReceta2();
                break;
            case R.id.rbReceta3:
                mostrarReceta3();
                break;
            case R.id.btn_profile_home:
                mostrarAccount();
                break;
        }
    }

    private void mostrarReceta1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cookbook, new Receta1Fragment())
                .commit();
    }

    private void mostrarReceta2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cookbook, new Receta2Fragment())
                .commit();
    }

    private void mostrarReceta3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cookbook, new Receta3Fragment())
                .commit();
    }

    private void mostrarAccount() {
        startActivity(new Intent(this, AccountActivity.class));
    }
}