// CarteAdapter.java
package com.example.pokecarddata.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pokecarddata.R;
import java.util.ArrayList;

public class CarteAdapter extends RecyclerView.Adapter<CarteAdapter.CartaViewHolder> {

    private final ArrayList<Integer> listaImmagini;

    public CarteAdapter() {
        this.listaImmagini = new ArrayList<>();
    }

    public void aggiungiCarta(int immagine) {
        listaImmagini.add(immagine);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardcollezionelayout, parent, false);
        return new CartaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartaViewHolder holder, int position) {
        int immagine = listaImmagini.get(position);
        holder.immagineCarta.setImageResource(immagine);
    }

    @Override
    public int getItemCount() {
        return listaImmagini.size();
    }

    static class CartaViewHolder extends RecyclerView.ViewHolder {
        ImageView immagineCarta;

        public CartaViewHolder(@NonNull View itemView) {
            super(itemView);
            immagineCarta = itemView.findViewById(R.id.fotoCard);
        }
    }
}
