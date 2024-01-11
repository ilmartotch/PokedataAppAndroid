package com.example.pokecarddata.api;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.pokecarddata.R;
import com.example.pokecarddata.dati.DatiCopertina;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatiApi {

    String urlPost = "https://api.pokemontcg.io/v2/sets";

    public void getPosts(final PostAsyncResponse callBack) {

        ArrayList<DatiCopertina> listaDatiCopertina = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, urlPost, null, response -> {

                    try{
                        for (int a = 0; a < response.length(); a++){
                            JSONObject card = response.getJSONObject(a);

                            String image = card.getString("symbol");
                            String logo = card.getString("logo");
                            String nomeSet = card.getString("name");
                            String idSet = card.getString("id");
                            int totalCard = card.getInt("total");

                            DatiCopertina datiCopertina = new DatiCopertina(image, logo, nomeSet, idSet, totalCard);
                            listaDatiCopertina.add(datiCopertina);
                        }

                        callBack.processoTerminato(listaDatiCopertina);

                    } catch (JSONException e){
                        e.printStackTrace();
                        callBack.processoFallito(e);
                    }

        }, error -> {
            Log.d("Main", "Error");
        });

        AppController.getInstance().addToRequestQueue(request);
    }

}

//allora... non va un cazzo, 18 errori e penso di aver implementato il codice di merda
//non so dove devo mettere l'ultima parte del codice
//devo implementare la libreria picasso per mostrare le immagini in app tramite il link http
//penso che poi lo scheletro dell'app sia fatto, manca solo la grafica ora