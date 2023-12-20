package com.example.progettodatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.progettodatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    protected User user;
    protected int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("luca", "martoccia", " ");
        binding.setUser(user);

        binding.bottone.setOnClickListener(view -> {
            user.setContatore("contatore: "+count++);
            if(count > 10){
                user.setContatore("il contatore ha finito di contare");

            }
        });

        binding.resetCount.setOnClickListener(view -> {
            user.setContatore(" ");
            count = 1;
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        binding = null;
    }
}