package com.example.pokecarddata.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokecarddata.dati.DatiCopertina;
import com.example.pokecarddata.R;
import com.example.pokecarddata.pagine.DettaglioSet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CopertinaAdapter extends RecyclerView.Adapter<CopertinaAdapter.CopertinaViewHolder> {
    private final ArrayList<DatiCopertina> dati;

    public CopertinaAdapter(ArrayList<DatiCopertina> dati) {
        this.dati = dati;
    }

    public static void filter(String newText) {
    }

    @NonNull
    @Override
    public CopertinaViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardset, parent, false);
        return new CopertinaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CopertinaViewHolder holder, int position) {
        holder.bind(dati.get(position));

        holder.image .setOnClickListener(v -> {
            Intent paginaDettaglioSet = new Intent(v.getContext(), DettaglioSet.class);
            paginaDettaglioSet.putExtra("dettaglio",dati.get(position));
            v.getContext().startActivity(paginaDettaglioSet);

        });

    }

    @Override
    public int getItemCount(){
        return dati.size();
    }

    public void setFilter(ArrayList<DatiCopertina> datifiltrati) {
    }

    static class CopertinaViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;

        public CopertinaViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.copertinaSet);

        }

        public void bind(DatiCopertina dati) {
            image.setImageResource(R.drawable.sfondo_pokedata);
            Picasso.get()
                    .load(dati.getImage())
                    .into(image, new com.squareup.picasso.Callback(){
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });

            TextView nomeSet = itemView.findViewById(R.id.testoSottoImmagine);
            nomeSet.setText(dati.getNomeSet());

        }

    }

}
