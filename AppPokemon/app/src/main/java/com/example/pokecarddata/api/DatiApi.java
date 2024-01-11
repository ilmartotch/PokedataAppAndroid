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
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.pokecarddata.R;
import com.example.pokecarddata.dati.DatiCopertina;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatiApi {

    public JSONArray jsonArray;
    String urlPost = "https://api.pokemontcg.io/v2/sets";

    public void getPosts(final PostAsyncResponse callBack) {

        ArrayList<DatiCopertina> listaDatiCopertina = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, urlPost, null, response -> {

                    try{
                        jsonArray = response.getJSONArray("data");

                        for (int i=0; i < jsonArray.length(); i++){
                            String logo=jsonArray.getJSONObject(i).getJSONObject("images").getString("logo");
                            String name = jsonArray.getJSONObject(i).getString("name");
                            String id =jsonArray.getJSONObject(i).getString("id");
                            int nCards = jsonArray.getJSONObject(i).getInt("total");
                            listaDatiCopertina.add(new DatiCopertina(logo,"", name, id, nCards));
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