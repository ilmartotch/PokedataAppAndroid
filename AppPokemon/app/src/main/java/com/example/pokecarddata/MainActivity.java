package com.example.pokecarddata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bottoneCollezione = findViewById(R.id.collezione);

        bottoneCollezione.setOnClickListener(v -> {
            Intent paginaCollezione = new Intent(MainActivity.this, Collezione.class);
            startActivity(paginaCollezione);
        });

        Button bottoneSetCarte = findViewById(R.id.setCarte);

        bottoneSetCarte.setOnClickListener(v -> {
            Intent paginaSetCarte = new Intent(MainActivity.this, SetCarte.class);
            startActivity(paginaSetCarte);
        });


    }

}