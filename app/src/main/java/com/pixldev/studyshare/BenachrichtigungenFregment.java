package com.pixldev.studyshare;

import android.content.Context;
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

public class BenachrichtigungenFregment extends Fragment {

    private OnNotificationCountChangeListener notificationCountChangeListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Überprüft, ob das Kontextobjekt die Schnittstelle OnNotificationCountChangeListener implementiert
        if (context instanceof OnNotificationCountChangeListener) {
            // Weist das Kontextobjekt der lokalen Variable zu
            notificationCountChangeListener = (OnNotificationCountChangeListener) context;
        } else {
            // Wirft eine Ausnahme, wenn die Schnittstelle nicht implementiert ist
            throw new RuntimeException(context.toString() + " must implement OnNotificationCountChangeListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.news_interaction_fragment, container, false);
        // Initialisiert RecyclerView
        RecyclerView benachrichtigungenRV = view.findViewById(R.id.BenachrichtigungenRV);
        benachrichtigungenRV.setLayoutManager(new LinearLayoutManager(getContext()));

        // Erstellt und fügt Daten hinzu
        ArrayList<Benachrichtigungsmodel> BenachrichtigungsmodelArrayList = new ArrayList<>();
        BenachrichtigungsmodelArrayList.add(new Benachrichtigungsmodel("Kauf deines Dokuments", "Dein Dokument \"Übungszettel Genetik\" wurde von Fabian gekauft."));
        BenachrichtigungsmodelArrayList.add(new Benachrichtigungsmodel("Neuer Kommentar", "Neuer Kommentar zu deinem Dokument \"Übungszettel Genetik\" - User777: Wunderschönes Dokument, hat meine Klausur gecarried."));
        BenachrichtigungsmodelArrayList.add(new Benachrichtigungsmodel("Vorschlag", "Kennst du Hans aus deiner Stufe?"));

        // Setzt Adapter
        Benachrichtigungsadapter Benachrichtigungsadapter = new Benachrichtigungsadapter(getContext(), BenachrichtigungsmodelArrayList);
        benachrichtigungenRV.setAdapter(Benachrichtigungsadapter);

        // Benachrichtigt den Listener über die Anzahl der Benachrichtigungen, soll eigentlich über das Backend laufen ist nur da zu demo zwecken
        if (notificationCountChangeListener != null) {
            notificationCountChangeListener.onNotificationCountChange(Benachrichtigungsadapter.getItemCount());
        }

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        // Setzt den Listener auf null
        notificationCountChangeListener = null;
    }
}

