package com.example.listanomi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DettaglioNomi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_nomi);

        Button button = findViewById(R.id.button_torna);

        TextView textView = findViewById(R.id.PaginaDettaglio);

        String nome = getIntent().getStringExtra("nome");

        textView.setText(getIntent().getStringExtra("nome"));

        button.setOnClickListener(v -> {
            finish();
        });
    }
}