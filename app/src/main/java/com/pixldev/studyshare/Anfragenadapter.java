package com.pixldev.studyshare;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class Anfragenadapter extends RecyclerView.Adapter<Anfragenadapter.ViewHolder> {

    // Liste der Anfragenmodel-Objekte und Kontext
    private final ArrayList<Anfragenmodel> anfragenModelArrayList;
    private final Context context;
    private static final String TAG = "Anfragenadapter";

    // Konstruktor für den Adapter
    public Anfragenadapter(Context context, ArrayList<Anfragenmodel> anfragenModelArrayList) {
        this.context = context;
        this.anfragenModelArrayList = anfragenModelArrayList;
    }

    // Erstellt neue ViewHolder-Instanzen
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate das Layout für jedes RecyclerView-Element
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_anfragen_recyclerview, parent, false);

        // Initialisiere die Buttons und setze OnClickListener für "ablehen" und "annehmen"
        Button ablehen = view.findViewById(R.id.dismissButton);
        Button annehmen = view.findViewById(R.id.confirmButton);
        ablehen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "abgelehnt");//zu Testzwecken gibt es eine ausgabe im Logcat
            }
        });
        annehmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "angemommen");
            }
        });

        return new ViewHolder(view);
    }

    // Verbindet die Daten mit den ViewHolder-Elementen
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Holt das aktuelle Anfragenmodel
        Anfragenmodel model = anfragenModelArrayList.get(position);

        // Setzt die Daten in die TextViews und ImageView des ViewHolders
        holder.nameTV.setText(model.getnameanfarge());
        holder.stufeTV.setText(model.getstufeanfarge());
        holder.anfragenThumbnailIV.setImageResource(model.getanfarge_thumbnail());

        // Setzt OnClickListener für den gesamten ViewHolder, um ein neues Fragment zu laden
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Erstellt ein neues Fragment und ein Bundle für die Argumente
                Fragment newFragment = new detailFragment();
                Bundle args = new Bundle();
                args.putString("name", model.getnameanfarge());
                args.putString("stufe", model.getstufeanfarge());
                args.putInt("anfragen_thumbnail", model.getanfarge_thumbnail());
                newFragment.setArguments(args);

                // Holt den FragmentManager und startet eine Transaktion, um das Fragment zu ersetzen
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, newFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    // Gibt die Anzahl der Elemente in der Liste zurück
    @Override
    public int getItemCount() {
        return anfragenModelArrayList.size();
    }

    // ViewHolder-Klasse, die die UI-Elemente für jedes RecyclerView-Element hält
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView anfragenThumbnailIV;
        private final TextView nameTV;
        private final TextView stufeTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anfragenThumbnailIV = itemView.findViewById(R.id.anfragen_thumbnail);
            nameTV = itemView.findViewById(R.id.name);
            stufeTV = itemView.findViewById(R.id.docCount);
        }
    }
}
