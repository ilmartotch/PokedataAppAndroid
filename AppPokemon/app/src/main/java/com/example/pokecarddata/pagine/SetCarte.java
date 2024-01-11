package com.example.pokecarddata.pagine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pokecarddata.R;
import com.example.pokecarddata.adapter.CopertinaAdapter;
import com.example.pokecarddata.api.DatiApi;
import com.example.pokecarddata.api.PostAsyncResponse;
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


        new DatiApi().getPosts(new PostAsyncResponse() {
            @Override
            public void processoTerminato(ArrayList<DatiCopertina> listaDatiCopertina) {
                RecyclerView recyclerView = findViewById(R.id.listaSet);
                recyclerView.setLayoutManager(new GridLayoutManager(SetCarte.this, 2));
                CopertinaAdapter projectsAdapter = new CopertinaAdapter(listaDatiCopertina);

                recyclerView.setAdapter(projectsAdapter);

            }

            @Override
            public void processoFallito(Exception e) {
                Log.d("Errore", e.getMessage());
            }

        });

    }
}