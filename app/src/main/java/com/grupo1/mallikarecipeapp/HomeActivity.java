package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.ScrollView;

import com.grupo1.mallikarecipeapp.fragments.Receta1Fragment;
import com.grupo1.mallikarecipeapp.fragments.Receta2Fragment;
import com.grupo1.mallikarecipeapp.fragments.Receta3Fragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RadioButton rbReceta1 = findViewById(R.id.rbReceta1);
        RadioButton rbReceta2 = findViewById(R.id.rbReceta2);
        RadioButton rbReceta3 = findViewById(R.id.rbReceta3);
        Button btnAccount = findViewById(R.id.btn_profile_home);
        Button btnHome = findViewById(R.id.btn_home);

        scrollView = findViewById(R.id.home_scroll_view);

        rbReceta1.setOnClickListener(this);
        rbReceta2.setOnClickListener(this);
        rbReceta3.setOnClickListener(this);
        btnAccount.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        rbReceta1.setChecked(true);
        showRecipe1();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbReceta1:
                showRecipe1();
                break;
            case R.id.rbReceta2:
                showRecipe2();
                break;
            case R.id.rbReceta3:
                showRecipe3();
                break;
            case R.id.btn_profile_home:
                goToAccount();
                break;
            case R.id.btn_home:
                goToHome();
                break;
            case R.id.btn_search:
                goToSearch();
                break;
        }
    }

    private void goToSearch() {
        startActivity(new Intent(this, RecycleViewActivity.class));
    }

    private void showRecipe1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cookbooks, new Receta1Fragment())
                .commit();
    }

    private void showRecipe2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cookbooks, new Receta2Fragment())
                .commit();
    }

    private void showRecipe3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cookbooks, new Receta3Fragment())
                .commit();
    }

    private void goToAccount() {
        startActivity(new Intent(this, AccountActivity.class));
    }

    private void goToHome() {
        scrollView.smoothScrollTo(0, 0);
    }
}