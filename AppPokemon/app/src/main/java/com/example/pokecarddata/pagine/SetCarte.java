package com.example.pokecarddata.pagine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

       // RecyclerView recyclerView = findViewById(R.id.listaSet);
//        CopertinaAdapter projectsAdapter = new CopertinaAdapter(listaDatiCopertina);
//        recyclerView.setAdapter(projectsAdapter);

        new DatiApi().getPosts(new PostAsyncResponse() {
            @Override
            public void processoTerminato(ArrayList<DatiCopertina> listaDatiCopertina) {
                ListView listView = findViewById(R.id.listaSet);
                ArrayAdapter<DatiCopertina> arrayAdapter = new ArrayAdapter<DatiCopertina>(
                        SetCarte.this,
                        android.R.layout.simple_list_item_2,
                        android.R.id.text1,
                        listaDatiCopertina) {
                    @NonNull
                    @Override
                    public View getView(int position,
                                        @Nullable View convertView,
                                        @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                        TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                        text1.setText(listaDatiCopertina.get(position).getImage());
                        return view;
                    }
                };

                listView.setAdapter(arrayAdapter);

            }

            @Override
            public void processoFallito(Exception e) {
                Log.d("Errore", e.getMessage());
            }

        });

    }
}