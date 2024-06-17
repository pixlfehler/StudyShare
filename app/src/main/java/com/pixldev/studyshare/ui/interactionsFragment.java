package com.pixldev.studyshare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pixldev.studyshare.AnfragenFregment;
import com.pixldev.studyshare.BenachrichtigungenFregment;
import com.pixldev.studyshare.FreundeFragment;
import com.pixldev.studyshare.R;

public class interactionsFragment extends Fragment {
    public boolean erstesmal = true; // Variable, um zu verfolgen, ob es das erste Mal ist, dass das Fragment geladen wird

    public interactionsFragment() {
        // Erforderlicher leerer öffentlicher Konstruktor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate das Layout für dieses Fragment
        View view = inflater.inflate(R.layout.fragment_interactions, container, false);

        // Initialisiere Buttons
        Button buttonFreunde = view.findViewById(R.id.buttonFreunde);
        Button buttonFreundeFinden = view.findViewById(R.id.button2);
        Button buttonneues = view.findViewById(R.id.button3);

        // Lade das FreundeFragment beim ersten Mal, wenn das Fragment geladen wird
        if (erstesmal) {
            loadFragment(new FreundeFragment());
            erstesmal = false; // Setze erstesmal auf false, damit dieses Fragment nicht erneut geladen wird
        }

        // Setze OnClickListener für den buttonFreunde
        buttonFreunde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FreundeFragment());
            }
        });

        // Setze OnClickListener für den buttonFreundeFinden
        buttonFreundeFinden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AnfragenFregment());
            }
        });

        // Setze OnClickListener für den buttonneues
        buttonneues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BenachrichtigungenFregment());
            }
        });

        return view; // Rückgabe des Views
    }

    // Methode zum Laden eines Fragments in den Container
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment); // Ersetze den Containerinhalt durch das neue Fragment
        fragmentTransaction.addToBackStack(null); // Füge die Transaktion zum Backstack hinzu, damit der Benutzer zurück navigieren kann
        fragmentTransaction.commit(); // Bestätige die Transaktion
    }
}
