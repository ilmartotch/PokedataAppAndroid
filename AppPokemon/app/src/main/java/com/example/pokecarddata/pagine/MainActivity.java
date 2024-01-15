package com.example.pokecarddata.pagine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.pokecarddata.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bottoneListaCarte = findViewById(R.id.listaCarte);

        bottoneListaCarte.setOnClickListener(v -> {
            Intent paginaListaCarte = new Intent(MainActivity.this, ListaCarte.class);
            startActivity(paginaListaCarte);
        });

        Button bottoneSetCarte = findViewById(R.id.setCarte);

        bottoneSetCarte.setOnClickListener(v -> {
            Intent paginaSetCarte = new Intent(MainActivity.this, SetCarte.class);
            startActivity(paginaSetCarte);
        });


    }
}
