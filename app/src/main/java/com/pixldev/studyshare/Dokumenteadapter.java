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
        holder.dokumentfachTV.setText(model.getdokument_fach());
        holder.dokumenttypTV.setText(model.getDokument_typ());
        holder.dokumentstufeTV.setText(model.getDokument_klasse());
        holder.dokumentIV.setImageResource(model.getdokument_image());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment=new detailFragment();

                Bundle args=new Bundle();
                args.putString("title",model.getdokument_name());
                args.putString("fach",model.getdokument_fach());
                args.putString("typ",model.getDokument_typ());
                args.putString("stufe", model.getDokument_klasse());
                args.putInt("image",model.getdokument_image());
                args.putParcelableArrayList("comments",model.getComments());
                args.putBoolean("inbesitz", model.getinbesitz());

                newFragment.setArguments(args);

                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, newFragment);
                fragmentTransaction.addToBackStack(null); // optional: um den Fragment-Wechsel rückgängig machen zu können

                fragmentTransaction.commit();
            }
        });
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
        private final TextView dokumenttypTV;
        private final TextView dokumentstufeTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dokumentIV = itemView.findViewById(R.id.freunde_thumbnail);
            titleDokumentTV = itemView.findViewById(R.id.name);
            dokumentfachTV = itemView.findViewById(R.id.Fach);
            dokumenttypTV = itemView.findViewById(R.id.Typ);
            dokumentstufeTV = itemView.findViewById(R.id.Stufe);
        }
    }
}
