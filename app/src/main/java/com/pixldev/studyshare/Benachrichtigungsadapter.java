package com.pixldev.studyshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Benachrichtigungsadapter extends RecyclerView.Adapter<Benachrichtigungsadapter.ViewHolder> {

    private final ArrayList<Benachrichtigungsmodel> BenachrichtigungsmodelArrayList; // ArrayList zur Speicherung von Benachrichtigungsmodel-Objekten
    private final Context context; // Context-Objekt für den Zugriff auf Ressourcen und andere Funktionen

    // Konstruktor zur Initialisierung des Adapters mit Daten und dem Kontext
    public Benachrichtigungsadapter(Context context, ArrayList<Benachrichtigungsmodel> benachrichtigungsmodelArrayList) {
        this.context = context;
        this.BenachrichtigungsmodelArrayList = benachrichtigungsmodelArrayList;
    }

    // Erstellt und füllt ViewHolder-Objekte
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_benachrichtigungen_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    // Bindet Daten an ViewHolder-Objekte
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Benachrichtigungsmodel model = BenachrichtigungsmodelArrayList.get(position); // Aktuelles Benachrichtigungsmodel-Objekt abrufen
        holder.artderbenachrichtigungTV.setText(model.getartderbenachrichtigung()); // Setzt den Text für artderbenachrichtigung
        holder.infotextTV.setText(model.getinfotext()); // Setzt den Text für infotext
    }

    // Gibt die Anzahl der Elemente im Datensatz zurück
    @Override
    public int getItemCount() {
        return BenachrichtigungsmodelArrayList.size(); // Größe des ArrayLists zurückgeben
    }

    // ViewHolder-Klasse zur Verwaltung und Steuerung von Ansichten
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView artderbenachrichtigungTV; // TextView für artderbenachrichtigung
        private final TextView infotextTV; // TextView für infotext

        // Konstruktor zur Initialisierung des ViewHolders mit itemView
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artderbenachrichtigungTV = itemView.findViewById(R.id.artderbenachrichtigung); // artderbenachrichtigungTV initialisieren
            infotextTV = itemView.findViewById(R.id.infotext); // infotextTV initialisieren
        }
    }
}
