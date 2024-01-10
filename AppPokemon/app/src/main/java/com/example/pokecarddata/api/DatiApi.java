package com.example.pokecarddata.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public interface PostAsyncResponse {
    void processoTerminato(ArrayList<Post> post);
    void processoFallito(Exception e);
}
public class DatiApi {

    String urlPost = "https://api.pokemontcg.io/v2/sets";

    public void getPosts(final PostAsyncResponse callBack) {
        ArrayList<Post> posts = new ArrayList<>();
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, urlPost, null, response -> {

                    try{
                        for (int a = 0; a < response.length(); a++){
                            JSONObject user = response.getJSONObject(a);

                            Post post = new Post();
                        }

                        callBack.processoTerminato(posts);

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
