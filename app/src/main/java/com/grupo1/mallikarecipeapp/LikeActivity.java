package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class LikeActivity extends AppCompatActivity implements View.OnClickListener {

//    private ConstraintLayout root;
    private ImageButton more_option1;
    private ImageButton more_option2;
    private ImageButton more_option3;
    private ImageButton more_option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        Button btnBack = findViewById(R.id.btn_back_liked);
//        root = findViewById(R.id.root);
        more_option1 = findViewById(R.id.menu1_liked);
        more_option2 = findViewById(R.id.menu2_liked);
        more_option3 = findViewById(R.id.menu3_liked);
        more_option4 = findViewById(R.id.menu4_liked);

        btnBack.setOnClickListener(this);
        more_option1.setOnClickListener(this);
        more_option2.setOnClickListener(this);
        more_option3.setOnClickListener(this);
        more_option4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            if (view.getId() == R.id.btn_back_liked)
                startActivity(new Intent(this, AccountActivity.class));
            else if (view.getId() == R.id.menu1_liked)
                showPopupMenu(more_option1);
            else if (view.getId() == R.id.menu2_liked)
                showPopupMenu(more_option2);
            else if (view.getId() == R.id.menu3_liked)
                showPopupMenu(more_option3);
            else if (view.getId() == R.id.menu4_liked)
                showPopupMenu(more_option4);
    }

    private void showPopupMenu(ImageButton option) {
        // Initialize the popup menu
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(), option);

        //inflate the popup menu
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.edit:
                        showMessage("Edit");
                        return true;
                    case R.id.aboveitem:
                        showMessage("Above Item");
                        return true;
                    case R.id.belowitem:
                        showMessage("Below Item");
                        return true;
                    case R.id.set:
                        showMessage("Set");
                        return true;
                    case R.id.delete:
                        showMessage("Delete");
                        return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    public void showMessage(String name) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context,"You clicked " + name, Toast.LENGTH_SHORT);
        toast.show();
    }
}