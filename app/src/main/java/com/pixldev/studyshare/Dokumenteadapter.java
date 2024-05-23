package com.pixldev.studyshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Dokumenteadapter extends RecyclerView.Adapter<Dokumenteadapter.ViewHolder> {

    private final ArrayList<Dokumentmodel> dokumentModelArrayList;
    private final Context context;

    // Constructor
    public Dokumenteadapter(Context context, ArrayList<Dokumentmodel> dokumentModelArrayList) {
        this.context = context;
        this.dokumentModelArrayList = dokumentModelArrayList;
    }

    @NonNull
    @Override
    public Dokumenteadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout für jedes Item des RecyclerViews aufblähen.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_startseite_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dokumenteadapter.ViewHolder holder, int position) {
        // Daten an die Views im ViewHolder binden.
        Dokumentmodel model = dokumentModelArrayList.get(position);
        holder.titleDokumentTV.setText(model.getdokument_name());
        holder.dokumentfachTV.setText(String.valueOf(model.getdokument_fach()));
        holder.dokumentIV.setImageResource(model.getdokument_image());
    }

    @Override
    public int getItemCount() {
        // Anzahl der Items im RecyclerView zurückgeben.
        return dokumentModelArrayList.size();
    }

    // ViewHolder-Klasse zur Initialisierung der Views.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView dokumentIV;
        private final TextView titleDokumentTV;
        private final TextView dokumentfachTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dokumentIV = itemView.findViewById(R.id.image_cardview);
            titleDokumentTV = itemView.findViewById(R.id.title_dokument_pl);
            dokumentfachTV = itemView.findViewById(R.id.Fach);
        }
    }
}
