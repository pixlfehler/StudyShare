package com.pixldev.studyshare;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.pixldev.studyshare.ui.detailFragment;

public class Startseite extends AppCompatActivity implements OnNotificationCountChangeListener {

    private ActivityStartseiteBinding binding;
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Startseite", "onCreate: Startseite activity created");

        binding = ActivityStartseiteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("Startseite", "binding");

        navView = findViewById(R.id.nav_view);
        Log.d("Startseite", "finding nav_view");
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.HomeFragment, R.id.searchFragment, R.id.libraryFragment, R.id.interactionsFragment, R.id.accountFragment)
                .build();
        Log.d("Startseite", "appbarconfig successful");
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        Log.d("Startseite", "navcontroller erstellt");
        NavigationUI.setupWithNavController(navView, navController);

        // Set an initial badge number if necessary
        navView.getOrCreateBadge(R.id.interactionsFragment).setNumber(0);
    }

    @Override
    public void onNotificationCountChange(int count) {
        navView.getOrCreateBadge(R.id.interactionsFragment).setNumber(count);
    }
}
