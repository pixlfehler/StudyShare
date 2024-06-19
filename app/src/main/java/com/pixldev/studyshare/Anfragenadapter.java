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

import com.pixldev.studyshare.ui.UserDetailFragment;
import com.pixldev.studyshare.ui.detailFragment;
import java.util.ArrayList;

public class Anfragenadapter extends RecyclerView.Adapter<Anfragenadapter.ViewHolder> {

    // Liste der Freundemodel-Objekte und Kontext
    private final ArrayList<Freundemodel> FreundemodelArrayList;
    private final Context context;
    private static final String TAG = "Anfragenadapter";

    // Konstruktor für den Adapter
    public Anfragenadapter(Context context, ArrayList<Freundemodel> FreundemodelArrayList) {
        this.context = context;
        this.FreundemodelArrayList = FreundemodelArrayList;
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
        // Holt das aktuelle Freundemodel
        Freundemodel model = FreundemodelArrayList.get(position);

        // Setzt die Daten in die TextViews und ImageView des ViewHolders
        holder.nameTV.setText(model.getname()+" ("+model.getUsername()+")");
        holder.stufeTV.setText("Stufe: "+model.getstufe());
        holder.anfragenThumbnailIV.setImageResource(model.getfreunde_thumbnail());

        // Setzt OnClickListener für den gesamten ViewHolder, um ein neues Fragment zu laden
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Erstellt ein neues Fragment und ein Bundle für die Argumente
                Fragment newFragment = new UserDetailFragment();

                Bundle args = new Bundle();
                args.putString("name", model.getname());
                args.putString("username", model.getUsername());
                args.putString("stufe", model.getstufe());
                args.putInt("friendCount",model.getFriendCount());
                args.putInt("profilePic", model.getfreunde_thumbnail());

                newFragment.setArguments(args);

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
        return FreundemodelArrayList.size();
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
