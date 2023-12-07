package com.example.listaprogetti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Project[] projects = {
            new Project("progetto 1", "descrizione 1", R.drawable.img1),
            new Project("progetto 2", "descrizione 2", R.drawable.img2),
            new Project("progetto 3", "descrizione 3", R.drawable.img3),
            new Project("progetto 4", "descrizione 4", R.drawable.img4),
            new Project("progetto 5", "descrizione 5", R.drawable.img5),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_projects);
        ProjectAdapter projectsAdapter = new ProjectAdapter(projects);
        recyclerView.setAdapter(projectsAdapter);
    }
}