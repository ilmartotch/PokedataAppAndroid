package com.example.pokecarddata.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokecarddata.dati.DatiCopertina;
import com.example.pokecarddata.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CopertinaAdapter extends RecyclerView.Adapter<CopertinaAdapter.CopertinaViewHolder> {

    private ArrayList<DatiCopertina> dati;

    public CopertinaAdapter(ArrayList<DatiCopertina> dati) {
        this.dati = dati;
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
    }

    @Override
    public int getItemCount(){
        return dati.size();
    }

    static class CopertinaViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        //private final TextView textView;
        public CopertinaViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.copertinaSet);
            //textView = itemView.findViewById(R.id.)
        }

        public void bind(DatiCopertina dati) {
            image.setImageResource(R.drawable.ic_launcher_background);
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
        }
    }

}
