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
        ArrayList<Freundemodel> userModelArrayList = new ArrayList<>();
        userModelArrayList.add(new Freundemodel("Richard", "RichiPitchi", "8",13, R.drawable.sample_profile_pic2));
        userModelArrayList.add(new Freundemodel("Herbert","Herberti111", "8", 2, R.drawable.sample_profile_pic));
        userModelArrayList.add(new Freundemodel("Emmanuel","Enderbug", "Q1", 2, R.drawable.sample_profile_pic5));
        userModelArrayList.add(new Freundemodel("Boris Meltzow","MEL77", "Lehrer", 2, R.drawable.sample_profile_pic6));

        // Erstellt einen Adapter mit der Liste der Anfragenmodel-Objekte
        Anfragenadapter anfragenAdapter = new Anfragenadapter(getContext(), userModelArrayList);

        // Setzt den Adapter für das RecyclerView
        anfragenRV.setAdapter(anfragenAdapter);

        // Gibt die View für das Fragment zurück
        return view;
    }
}
