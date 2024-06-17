package com.pixldev.studyshare.ui;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pixldev.studyshare.Dokumenteadapter;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;
import com.pixldev.studyshare.UploadDialogFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Erforderlicher leerer öffentlicher Konstruktor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate das Layout für dieses Fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Referenz auf die RecyclerView
        RecyclerView courseRV = view.findViewById(R.id.RVmeinedokumente);

        // Referenz auf den FloatingActionButton
        FloatingActionButton newDocButton = view.findViewById(R.id.newDocButton);

        // Liste von Dokumentmodellen erstellen und füllen als Beispiel
        ArrayList<Dokumentmodel> dokumentmodelArrayList = new ArrayList<>();
        dokumentmodelArrayList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe", "7", R.drawable.document_placeholder, false));
        dokumentmodelArrayList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder, false));
        dokumentmodelArrayList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder, false));
        dokumentmodelArrayList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder, false));
        dokumentmodelArrayList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder, false));
        dokumentmodelArrayList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder, false));

        // Adapter für die RecyclerView erstellen
        Dokumenteadapter courseAdapter = new Dokumenteadapter(getContext(), dokumentmodelArrayList);

        // LayoutManager für die RecyclerView setzen
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        // LayoutManager und Adapter für RecyclerView setzen
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);

        // OnClickListener für den FloatingActionButton welcher für das erstellen neuer Angebote ist
        newDocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UploadDialogFragment anzeigen
                UploadDialogFragment dialogFragment = new UploadDialogFragment();
                dialogFragment.show(getChildFragmentManager(), "UploadDialog");
            }
        });

        return view; // Rückgabe des Views
    }

    // Methode zum Anzeigen des Bestätigungsdialogs
    public void showConfirmTransactionDialog() {
        Dialog dialog = new Dialog(getContext());

        // Layout für den Dialog setzen
        dialog.setContentView(R.layout.yes_no_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // Überschrift des Dialogs setzen
        TextView heading = dialog.findViewById(R.id.heading);
        heading.setText("Test");

        dialog.show(); // Dialog anzeigen
    }

    // Methode zum Anzeigen des Dialogs für neue Dokumente
    public void showNewDocDialog() {
        Dialog dialog = new Dialog(getContext());

        // Layout für den Dialog setzen
        dialog.setContentView(R.layout.new_document_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // Button zum Schließen des Dialogs
        Button dismissButton = dialog.findViewById(R.id.dismissButton);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Dialog schließen
            }
        });

        dialog.show(); // Dialog anzeigen
    }
}
