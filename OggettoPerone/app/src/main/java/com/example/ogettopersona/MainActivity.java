package com.example.ogettopersona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

private final Persona[] listaPersone = {
        new Persona("luca", "rossi"),
        new Persona("giovanni", "verdi"),
        new Persona("tommaso", "bianchi"),
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Persona> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listaPersone);

        ListView list = findViewById((parent, view, i, id) -> {
           Persona persona = listaPersone[i];
           Intent intent = new Intent(MainActivity.this, DettaglioLista.class);
           intent.putExtra("persoone", persona);
           startActivity(intent);
        });
    }
}