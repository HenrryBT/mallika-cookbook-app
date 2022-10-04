package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class LikeActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout root;
    private ImageButton more_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        Button btnBack = findViewById(R.id.btn_back_liked);

        btnBack.setOnClickListener(this);

        root = findViewById(R.id.root);
        more_option =findViewById(R.id.menu1);

        more_option.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            // Initialize the popup menu
            PopupMenu popupMenu = new PopupMenu(getApplicationContext(),more_option);

            //inflate the popup menu
            popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.edit:;
                                return true;
                            case R.id.aboveitem:
                                return true;
                            case R.id.belowitem:
                                return true;
                            case R.id.set:
                                return true;
                            case R.id.delete:;
                                return true;
                        }
                        return false;
                    }

                    });
                    popupMenu.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, AccountActivity.class));
    }
}