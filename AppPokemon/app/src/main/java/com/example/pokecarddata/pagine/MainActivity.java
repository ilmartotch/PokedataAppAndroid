package com.example.pokecarddata.pagine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pokecarddata.R;
import com.example.pokecarddata.api.DatiApi;
import com.example.pokecarddata.api.PostAsyncResponse;
import com.example.pokecarddata.dati.DatiCopertina;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
