package com.pixldev.studyshare.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pixldev.studyshare.Dokumenteadapter_tworows;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;
import com.pixldev.studyshare.UploadDialogFragment;

import java.util.ArrayList;

public class accountFragment extends Fragment {

    // Standardkonstruktor für das Fragment, wird benötigt
    public accountFragment() {
    }

    // Erstellt und gibt die View-Hierarchie des Fragments zurück
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_account, null);

        FloatingActionButton newDocButton = view1.findViewById(R.id.newDocButton);

        // RecyclerView wird aus der Layout-Datei geholt
        RecyclerView recyclerView = view1.findViewById(R.id.dokumentRV);
        recyclerView.setHasFixedSize(true); // Optimiert die Leistung, da sich die Größe des RecyclerView nicht ändert
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // GridLayoutManager mit zwei Spalten

        // Erstellen und Befüllen der ArrayList mit Beispieldaten
        ArrayList<Dokumentmodel> itemList = new ArrayList<>();
        itemList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        itemList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe", "7", R.drawable.document_placeholder2, false));
        itemList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder3, false));
        itemList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder3, false));
        itemList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder2, false));

        // Erstellen und Setzen des Adapters für die RecyclerView
        Dokumenteadapter_tworows adapter = new Dokumenteadapter_tworows(getContext(), itemList);
        recyclerView.setAdapter(adapter);

        newDocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UploadDialogFragment anzeigen
                UploadDialogFragment dialogFragment = new UploadDialogFragment();
                dialogFragment.show(getChildFragmentManager(), "UploadDialog");
            }
        });

        // Rückgabe der erzeugten View
        return view1;
    }
}
