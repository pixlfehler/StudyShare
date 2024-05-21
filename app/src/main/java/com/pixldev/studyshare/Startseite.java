package com.pixldev.studyshare;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pixldev.studyshare.databinding.ActivityStartseiteBinding;

public class Startseite extends AppCompatActivity {

    private ActivityStartseiteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_startseite);
        Log.d("Startseite", "onCreate: Startseite activity created");


        binding = ActivityStartseiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("Startseite", "binding");

        BottomNavigationView navView = findViewById(R.id.nav_view);
        Log.d("Startseite", "finding nav_view");
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.HomeFragment, R.id.searchFragment, R.id.libraryFragment, R.id.interactionsFragment, R.id.accountFragment)
                .build();
        Log.d("Startseite", "appbarconfig successful");
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Log.d("Startseite", "naccontroller erstellt");
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        Log.d("Startseite", "vorm connecten");
        NavigationUI.setupWithNavController(navView, navController);

    }

}