package com.pixldev.studyshare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pixldev.studyshare.Dokumenteadapter;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;

import java.util.ArrayList;

public class libraryFragment extends Fragment {

    public libraryFragment() {
        // Erforderlicher leerer öffentlicher Konstruktor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate das Layout für dieses Fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        // Initialisiere den RecyclerView und setze das Layout auf LinearLayoutManager
        RecyclerView meinedokumenteRV = view.findViewById(R.id.RVmeinedokumente);
        meinedokumenteRV.setLayoutManager(new LinearLayoutManager(getContext()));

        // Erstelle eine ArrayList von Dokumentmodel-Objekten und füge einige Beispiel-Dokumente hinzu
        ArrayList<Dokumentmodel> dokumentmodelArrayList = new ArrayList<>();
        dokumentmodelArrayList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe", "7", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder, true));

        // Erstelle einen Dokumenteadapter und setze ihn auf den RecyclerView
        Dokumenteadapter dokumentAdapter = new Dokumenteadapter(getContext(), dokumentmodelArrayList);
        meinedokumenteRV.setAdapter(dokumentAdapter);

        return view; // Rückgabe des Views
    }
}
