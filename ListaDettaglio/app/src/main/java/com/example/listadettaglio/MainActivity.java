package com.example.listadettaglio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    String[] nomi = {"luca", "tommaso", "giovanni"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                nomi
        );

        ListView lista = findViewById(R.id.mialista);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, Dettaglio.class);
            intent.putExtra("nome", nomi[position]);
            startActivity(intent);
        });
    }
}