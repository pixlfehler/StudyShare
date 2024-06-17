package com.pixldev.studyshare.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.pixldev.studyshare.Dokumentadapter_tworows_noneditable;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;
import java.util.ArrayList;

public class UserDetailFragment extends Fragment {

    // Leerer Konstruktor für das Fragment
    public UserDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate das Layout für dieses Fragment
        View view1 = inflater.inflate(R.layout.fragment_user_detail, container, false);

        // Initialisiere TextViews und ImageView für Benutzerinformationen
        TextView usernameTV = view1.findViewById(R.id.usernameTV);
        TextView stufe = view1.findViewById(R.id.stufe);
        TextView friendCount = view1.findViewById(R.id.friendCount);
        ImageView profilePic = view1.findViewById(R.id.profilePicIV);

        // Initialisiere den RecyclerView
        RecyclerView recyclerView = view1.findViewById(R.id.dokumentRV);

        // Überprüfe, ob Argumente vorhanden sind, und setze die entsprechenden Werte
        if (getArguments() != null) {
            Bundle args = getArguments();
            usernameTV.setText(args.getString("username"));
            stufe.setText(args.getString("stufe"));
            friendCount.setText(args.getInt("friendCount") + " Freunde");
            profilePic.setImageResource(args.getInt("profilePic"));
        }

        // Setze den RecyclerView auf eine feste Größe und verwende ein GridLayoutManager mit zwei Spalten
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Erstelle eine Liste von Dokumentmodellen und füge einige Beispiel-Dokumente hinzu
        ArrayList<Dokumentmodel> itemList = new ArrayList<>();
        itemList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        itemList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe", "7", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder, false));
        itemList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder, false));
        // Füge weitere Daten zur itemList hinzu, wenn nötig

        // Erstelle einen Dokumenteadapter und setze ihn auf den RecyclerView
        Dokumentadapter_tworows_noneditable adapter = new Dokumentadapter_tworows_noneditable(getContext(), itemList);
        recyclerView.setAdapter(adapter);

        // Rückgabe des Fragments
        return view1;
    }
}
