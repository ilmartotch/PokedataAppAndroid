package com.example.listadettaglio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Dettaglio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio);

        Button button = findViewById(R.id.button_torna);

        TextView textView = findViewById(R.id.PaginaDettaglio);

        String nome = getIntent().getStringExtra("nome");

        textView.setText(getIntent().getStringExtra("nome"));

        button.setOnClickListener(v -> {
            finish();
        });

    }
}