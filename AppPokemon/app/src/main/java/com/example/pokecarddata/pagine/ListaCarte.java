package com.example.pokecarddata.pagine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


        Button bottoneCollegamento = findViewById(R.id.collegamentoAltreCarte);
        bottoneCollegamento.setOnClickListener(view -> {
            String url = "https://www.pokedata.io/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        RecyclerView recyclerView = findViewById(R.id.listaCarte);
        recyclerView.setLayoutManager(new GridLayoutManager(ListaCarte.this, 1));


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