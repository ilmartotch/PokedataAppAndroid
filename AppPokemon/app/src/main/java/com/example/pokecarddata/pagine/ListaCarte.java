package com.example.pokecarddata.pagine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.pokecarddata.R;
import com.example.pokecarddata.adapter.CarteAdapter;

public class ListaCarte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carte);

        ImageButton backButton = findViewById(R.id.backHomeCollezione);

        backButton.setOnClickListener(view -> {
            finish();
        });

        RecyclerView recyclerView = findViewById(R.id.listaCarte);
        recyclerView.setLayoutManager(new GridLayoutManager(ListaCarte.this, 2));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CarteAdapter carteAdapter = new CarteAdapter();
        recyclerView.setAdapter(carteAdapter);

        carteAdapter.aggiungiCarta(R.drawable.charizard);
        carteAdapter.aggiungiCarta(R.drawable.giratina_v);
        carteAdapter.aggiungiCarta(R.drawable.mewtwo);
        carteAdapter.aggiungiCarta(R.drawable.pikachu);

    }
}