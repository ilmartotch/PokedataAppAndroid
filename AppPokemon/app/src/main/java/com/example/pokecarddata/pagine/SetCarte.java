package com.example.pokecarddata.pagine;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SearchView;

import com.example.pokecarddata.R;
import com.example.pokecarddata.adapter.CopertinaAdapter;
import com.example.pokecarddata.api.RaccoltaDatiApi;
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


        new RaccoltaDatiApi().getPosts(new PostAsyncResponse() {
            @Override
            public void processoTerminato(ArrayList<DatiCopertina> listaDatiCopertina) {
                RecyclerView recyclerView = findViewById(R.id.listaSet);
                recyclerView.setLayoutManager(new GridLayoutManager(SetCarte.this, 1));
                CopertinaAdapter projectsAdapter = new CopertinaAdapter(listaDatiCopertina);

                recyclerView.setAdapter(projectsAdapter);

            }

            @Override
            public void processoFallito(Exception e) {
                Log.d("Errore", e.getMessage());
            }

        });

        SearchView searchView = findViewById(R.id.ricercaSet);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                CopertinaAdapter.filter(newText);
                return true;
            }
        });

        new RaccoltaDatiApi().getPosts(new PostAsyncResponse() {
            @Override
            public void processoTerminato(ArrayList<DatiCopertina> listaDatiCopertina) {
                RecyclerView recyclerView = findViewById(R.id.listaSet);
                recyclerView.setLayoutManager(new GridLayoutManager(SetCarte.this, 1));
                CopertinaAdapter nuovaListaSet = new CopertinaAdapter(listaDatiCopertina);
                recyclerView.setAdapter(nuovaListaSet);
            }

            @Override
            public void processoFallito(Exception e) {
            }
        });

    }
}