package com.pixldev.studyshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pixldev.studyshare.R;

public class RegistrateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        Button registrateButton=findViewById(R.id.registrateConfirmButton);
        CardView myCV=findViewById(R.id.cardview);

        registrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrateActivity.this, SubjectSelectActivity.class);
                Activity activity=(Activity)RegistrateActivity.this;

                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(RegistrateActivity.this, myCV, ViewCompat.getTransitionName(myCV));
                activity.startActivity(intent,optionsCompat.toBundle());
            }
        });
    }
}