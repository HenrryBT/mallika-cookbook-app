package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.grupo1.mallikarecipeapp.fragments.Tip1Fragment;
import com.grupo1.mallikarecipeapp.fragments.Tip2Fragment;
import com.grupo1.mallikarecipeapp.fragments.Tip3Fragment;

public class TipsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        RadioButton rbTip1 = findViewById(R.id.rbTip1);
        RadioButton rbTip2 = findViewById(R.id.rbTip2);
        RadioButton rbTip3 = findViewById(R.id.rbTip3);

        rbTip1.setOnClickListener(this);
        rbTip2.setOnClickListener(this);
        rbTip3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbTip1:
                mostrarTip1();
                break;
            case R.id.rbTip2:
                mostrarTip2();
                break;
            case R.id.rbTip3:
                mostrarTip3();
                break;
        }
    }

    private void mostrarTip1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Tip1Fragment())
                .commit();
    }

    private void mostrarTip2() {getSupportFragmentManager().beginTransaction()
            .replace(R.id.contenedor, new Tip2Fragment())
            .commit();
    }

    private void mostrarTip3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, new Tip3Fragment())
                .commit();
    }
}