package com.pixldev.studyshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.pixldev.studyshare.ui.detailFragment;

import java.util.ArrayList;

public class Dokumenteadapter extends RecyclerView.Adapter<Dokumenteadapter.ViewHolder> {

    private final ArrayList<Dokumentmodel> dokumentModelArrayList; // Liste der Dokumentmodel-Objekte
    private final Context context; // Context-Objekt für den Zugriff auf Android-Ressourcen und -Funktionen

    // Konstruktor des Adapters
    public Dokumenteadapter(Context context, ArrayList<Dokumentmodel> dokumentModelArrayList) {
        this.context = context;
        this.dokumentModelArrayList = dokumentModelArrayList;
    }

    // Erstellt neue ViewHolder-Objekte für jedes Element in der Liste
    @NonNull
    @Override
    public Dokumenteadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_startseite_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dokumenteadapter.ViewHolder holder, int position) {
        // Daten für das aktuelle Dokumentmodell abrufen
        Dokumentmodel model = dokumentModelArrayList.get(position);

        // Setzen der Texte und Bilder in den Views des ViewHolders
        holder.titleDokumentTV.setText(model.getdokument_name());
        holder.dokumentfachTV.setText(model.getdokument_fach());
        holder.dokumenttypTV.setText(model.getDokument_typ());
        holder.dokumentstufeTV.setText(model.getDokument_klasse());
        holder.dokumentIV.setImageResource(model.getdokument_image());

        // OnClickListener für das gesamte Item setzen
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Neuen detailFragment erstellen
                Fragment newFragment = new detailFragment();

                // Bundle mit Daten für das detailFragment vorbereiten
                Bundle args = new Bundle();
                args.putString("title", model.getdokument_name());
                args.putString("fach", model.getdokument_fach());
                args.putString("typ", model.getDokument_typ());
                args.putString("stufe", model.getDokument_klasse());
                args.putInt("image", model.getdokument_image());
                args.putParcelableArrayList("comments", model.getComments());
                args.putBoolean("inbesitz", model.getinbesitz());

                // Argumente dem Fragment übergeben
                newFragment.setArguments(args);

                // FragmentManager und FragmentTransaction initialisieren
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Fragment in den Container (nav_host_fragment) ersetzen
                fragmentTransaction.replace(R.id.nav_host_fragment, newFragment);

                // Optional: Transaktion zum Back-Stack hinzufügen, um den Fragment-Wechsel rückgängig machen zu können
                fragmentTransaction.addToBackStack(null);

                // Transaktion durchführen
                fragmentTransaction.commit();
            }
        });
    }

    // Anzahl der Elemente in der RecyclerView zurückgeben
    @Override
    public int getItemCount() {
        return dokumentModelArrayList.size();
    }

    // ViewHolder-Klasse zur Initialisierung der Views in jedem einzelnen Element
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView dokumentIV;
        private final TextView titleDokumentTV;
        private final TextView dokumentfachTV;
        private final TextView dokumenttypTV;
        private final TextView dokumentstufeTV;

        // Konstruktor, der die Views im ViewHolder initialisiert
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dokumentIV = itemView.findViewById(R.id.anfragen_thumbnail);
            titleDokumentTV = itemView.findViewById(R.id.name);
            dokumentfachTV = itemView.findViewById(R.id.Fach);
            dokumenttypTV = itemView.findViewById(R.id.Typ);
            dokumentstufeTV = itemView.findViewById(R.id.Stufe);
        }
    }
}
