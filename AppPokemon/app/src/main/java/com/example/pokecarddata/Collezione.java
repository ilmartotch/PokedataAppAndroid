package com.example.pokecarddata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Collezione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collezione);

        Button backButton = findViewById(R.id.backHomeCollezione);

        backButton.setOnClickListener(view -> {
            finish();
        });

    }
}