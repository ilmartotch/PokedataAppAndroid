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

                            String image = user.getString("symbol");
                            String logo = user.getString("logo");
                            String nomeSet = user.getString("name");
                            String idSet = user.getString("id");
                            int totalCard = user.getInt("total");

                            Post post = new Post(image, logo, nomeSet, idSet, totalCard);
                            posts.add(post);
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

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            new Repository().getPosts(new PostAsyncResponse() {
               @Override
               public void processoTerminato(ArrayList<Post> posts){
                   ListView listView = findViewById(R.id.listaSet);
                   ArrayAdapter<Post> arrayAdapter = new ArrayAdapter<Post>(
                           MainActivity.this,
                           android.R.layout.simple_list_item_2,
                           android.R.id.text1,
                   posts) {
                       @NonNull
                       @Override
                       public View getView(int position,
                                           @NonNull View convertView,
                                           @NonNull ViewGroup parent) {
                           View view = super.getView(position, convertView, parent);
                           TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                           TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                           text1.setText(posts.get(position).getTitle());
                           text2.setText(posts.get(position).getBody().substring(0, 30));
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

}

//allora... non va un cazzo, 18 errori e penso di aver implementato il codice di merda
//non so dove devo mettere l'ultima parte del codice
//devo implementare la libreria picasso per mostrare le immagini in app tramite il link http
//penso che poi lo scheletro dell'app sia fatto, manca solo la grafica ora