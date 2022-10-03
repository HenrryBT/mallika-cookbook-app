package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        rbReceta1.setOnClickListener(this);
        rbReceta2.setOnClickListener(this);
        rbReceta3.setOnClickListener(this);
    }

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
        }
    }

    private void mostrarReceta1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Receta1Fragment())
                .commit();
    }

    private void mostrarReceta2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Receta2Fragment())
                .commit();
    }

    private void mostrarReceta3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Receta3Fragment())
                .commit();
    }
}