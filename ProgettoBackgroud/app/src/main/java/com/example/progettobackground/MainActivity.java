package com.example.progettobackground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.progettobackground.databinding.ActivityMainBinding;
import com.example.progettobackground.services.MyService;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final States states = new States();
    private Intent myServiceIntent;

    private Intent myForegroundServiceIntent;

    //private Button bottone = findViewById(R.id.startButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        myServiceIntent = new Intent(MainActivity.this, MyService.class);

        binding.startButton.setOnClickListener(view -> {
            states.setStarted(!states.getStarted());
            if(states.getStarted()){
                startService(myServiceIntent);
                binding.startButton.setText("Farma contatore");

            } else {
                binding.startButton.setText("Start contatore");
            }
        });

        binding.foregroundButton.setOnClickListener(view ->{
           states.setStartedForeground(!states.getStartedForeground());
           if(states.getStartedForeground()){
               startForegroundService(myForegroundServiceIntent);
           } else {
               stopService(myForegroundServiceIntent);
           }
        });

    }
}