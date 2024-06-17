package com.pixldev.studyshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AnfragenFregment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflates das Layout für dieses Fragment
        View view = inflater.inflate(R.layout.freunde_interaction_fragment, container, false);

        // Findet das RecyclerView-Element aus dem Layout
        RecyclerView anfragenRV = view.findViewById(R.id.BenachrichtigungenRV);

        // Setzt das LayoutManager für das RecyclerView auf ein LinearLayoutManager
        anfragenRV.setLayoutManager(new LinearLayoutManager(getContext()));

        // Erstellt eine Liste von Anfragenmodel-Objekten und fügt Dummy-Daten hinzu
        ArrayList<Anfragenmodel> anfragenModelArrayList = new ArrayList<>();
        anfragenModelArrayList.add(new Anfragenmodel("Person 1", "Stufe 1", R.drawable.document_placeholder));
        anfragenModelArrayList.add(new Anfragenmodel("Person 2", "Stufe 2", R.drawable.document_placeholder));
        anfragenModelArrayList.add(new Anfragenmodel("Person 3", "Stufe 3", R.drawable.document_placeholder));

        // Erstellt einen Adapter mit der Liste der Anfragenmodel-Objekte
        Anfragenadapter anfragenAdapter = new Anfragenadapter(getContext(), anfragenModelArrayList);

        // Setzt den Adapter für das RecyclerView
        anfragenRV.setAdapter(anfragenAdapter);

        // Gibt die View für das Fragment zurück
        return view;
    }
}
