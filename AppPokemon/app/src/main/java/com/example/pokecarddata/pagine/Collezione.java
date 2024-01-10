package com.example.pokecarddata.pagine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.pokecarddata.R;

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