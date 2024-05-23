package com.pixldev.studyshare;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
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
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        Log.d("Startseite", "naccontroller erstellt");
        NavigationUI.setupWithNavController(navView, navController);

    }
    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_startseite);
            RecyclerView courseRV = findViewById(R.id.RVdokument);

            // Here, we have created new array list and added data to it
            ArrayList<Dokumentmodel> dokumentmodelArrayList = new ArrayList<Dokumentmodel>();
            dokumentmodelArrayList.add(new Dokumentmodel("DSA in Java", "Bio", R.drawable.logo_placeholder));
            dokumentmodelArrayList.add(new Dokumentmodel("Java Course", "Bio", R.drawable.logo_placeholder));
            dokumentmodelArrayList.add(new Dokumentmodel("C++ Course", "Bio", R.drawable.logo_placeholder));
            dokumentmodelArrayList.add(new Dokumentmodel("DSA in C++", "Bio", R.drawable.logo_placeholder));
            dokumentmodelArrayList.add(new Dokumentmodel("Kotlin for Android", "Bio", R.drawable.logo_placeholder));
            dokumentmodelArrayList.add(new Dokumentmodel("Java for Android", "Bio", R.drawable.logo_placeholder));
            dokumentmodelArrayList.add(new Dokumentmodel("HTML and CSS", "Bio", R.drawable.logo_placeholder));

            // we are initializing our adapter class and passing our arraylist to it.
            Dokumenteadapter courseAdapter = new Dokumenteadapter(this, dokumentmodelArrayList);

            // below line is for setting a layout manager for our recycler view.
            // here we are creating vertical list so we will provide orientation as vertical
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

            // in below two lines we are setting layoutmanager and adapter to our recycler view.
            courseRV.setLayoutManager(linearLayoutManager);
            courseRV.setAdapter(courseAdapter);
        }
    }

}