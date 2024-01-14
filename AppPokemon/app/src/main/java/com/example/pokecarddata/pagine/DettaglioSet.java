package com.example.pokecarddata.pagine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokecarddata.R;
import com.example.pokecarddata.dati.DatiCopertina;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DettaglioSet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_set);


        Button backButton = findViewById(R.id.buttonBackSet);
        backButton.setOnClickListener(view -> {
            finish();
        });


        DatiCopertina datiCopertina = (DatiCopertina) (getIntent().getSerializableExtra("dettaglio"));

        TextView titoloSet = findViewById(R.id.titoloSet);
        titoloSet.setText("Titolo: " + datiCopertina.getNomeSet());

        TextView carteTotali = findViewById(R.id.carteTotali);
        carteTotali.setText("Carte Totali: " + datiCopertina.getTotalCard());


        TextView dataRilascio = findViewById(R.id.dataRilascio);
        dataRilascio.setText("Rilasciata il " + datiCopertina.getDataRilascio());

        ImageView copertinaDettaglio = findViewById(R.id.copertinaDettaglio);
        copertinaDettaglio.setImageResource(R.drawable.sfondo_pokedata);
        Picasso.get()
                .load(datiCopertina.getImage())
                .into(copertinaDettaglio, new com.squareup.picasso.Callback(){
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

    }
}