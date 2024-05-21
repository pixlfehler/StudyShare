package com.pixldev.studyshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import androidx.core.splashscreen.SplashScreen;
import com.airbnb.lottie.LottieAnimationView;

import com.pixldev.studyshare.R;

public class StartActivity extends AppCompatActivity {
    CardView myCV;
    Button loginButton,registrateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);
        animationView.setImageAssetsFolder("images");

        loginButton=findViewById(R.id.loginButton);
        registrateButton=findViewById(R.id.registrateButton);
        myCV=findViewById(R.id.cardview);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this, LoginActivity.class);
                Activity activity=(Activity)StartActivity.this;

                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(StartActivity.this, myCV,ViewCompat.getTransitionName(myCV));
                activity.startActivity(intent,optionsCompat.toBundle());
            }
        });

        registrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this, RegistrateActivity.class);
                Activity activity=(Activity)StartActivity.this;

                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(StartActivity.this, myCV,ViewCompat.getTransitionName(myCV));
                activity.startActivity(intent,optionsCompat.toBundle());
            }
        });
    }
}