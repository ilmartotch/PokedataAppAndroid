package com.example.pokecarddata.pagine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.pokecarddata.R;
import com.example.pokecarddata.adapter.CopertinaAdapter;
import com.example.pokecarddata.dati.DatiCopertina;

import java.util.ArrayList;

public class SetCarte extends AppCompatActivity {

    ArrayList<DatiCopertina> listaDatiCopertina = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_carte);

        Button backButton = findViewById(R.id.backHomeCarte);

        backButton.setOnClickListener(view -> {
            finish();
        });

        RecyclerView recyclerView = findViewById(R.id.listaSet);
        CopertinaAdapter projectsAdapter = new CopertinaAdapter(listaDatiCopertina);
        recyclerView.setAdapter(projectsAdapter);

    }
}