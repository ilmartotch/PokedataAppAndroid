package com.example.tabview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottonNav = findViewById(R.id.bottom_nav);

        bottonNav.setOnItemSelectedListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Objects.equals(v.getTitle(), "running") ? RunningFragment.class: CyclingFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("name")
                    .commit();

            return (true);
        });

    }
}