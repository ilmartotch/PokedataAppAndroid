package com.example.progettovolley.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.progettovolley.controller.AppController;
import com.example.progettovolley.model.Post;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Repository {

    String urlPost = "https://jsonplaceholder.typicode.com/posts";

    public void getPosts(final PostAsyncResponse callBack) {

        ArrayList<Post> posts = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, urlPost, null, response -> {

                    try{
                        for (int a = 0; a < response.length(); a++){
                            JSONObject user = response.getJSONObject(a);
                            long userId = user.getInt("userId");
                            long id = user.getInt("id");
                            String title = user.getString("title");
                            String body = user.getString("body");
                            Post post = new Post(userId, id, title, body);
                            posts.add(post);
                        }
                        callBack.processoTerminato(posts);
                    } catch (JSONException e){
                        e.printStackTrace();
                        callBack.processoFallito(e);
                    }
        }, error ->{
                    Log.d("Main", "Error");
        });

        AppController.getInstance().addToRequestQueue(request);

    }
}
