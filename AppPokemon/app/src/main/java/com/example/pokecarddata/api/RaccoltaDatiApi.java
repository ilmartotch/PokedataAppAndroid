package com.example.pokecarddata.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.pokecarddata.dati.DatiCopertina;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class RaccoltaDatiApi {

    public static JSONArray jsonArray;
    private static String urlPosts = "https://api.pokemontcg.io/v2/sets";

    public void getPosts(final PostAsyncResponse callBack) {

        ArrayList<DatiCopertina> listaDatiCopertina = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, urlPosts, null, response -> {

                    try{
                        jsonArray = response.getJSONArray("data");

                        for (int i=0; i < jsonArray.length(); i++){
                            String logo=jsonArray.getJSONObject(i).getJSONObject("images").getString("logo");
                            String name = jsonArray.getJSONObject(i).getString("name");
                            String id =jsonArray.getJSONObject(i).getString("id");
                            int totalCard = jsonArray.getJSONObject(i).getInt("total");
                            String dataRilascio = jsonArray.getJSONObject(i).getString("releaseDate");
                            listaDatiCopertina.add(new DatiCopertina(logo,"", name, id, totalCard, dataRilascio));
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