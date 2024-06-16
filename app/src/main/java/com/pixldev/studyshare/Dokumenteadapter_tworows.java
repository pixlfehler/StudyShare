package com.pixldev.studyshare;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class Dokumenteadapter_tworows extends RecyclerView.Adapter<Dokumenteadapter_tworows.ViewHolder> {

    private final ArrayList<Dokumentmodel> dokumentModelArrayList;
    private final Context context;

    // Constructor
    public Dokumenteadapter_tworows(Context context, ArrayList<Dokumentmodel> dokumentModelArrayList) {
        this.context = context;
        this.dokumentModelArrayList = dokumentModelArrayList;
    }

    @NonNull
    @Override
    public Dokumenteadapter_tworows.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout für jedes Item des RecyclerViews aufblähen.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dokument_tworows_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dokumenteadapter_tworows.ViewHolder holder, int position) {
        // Daten an die Views im ViewHolder binden.
        Dokumentmodel model = dokumentModelArrayList.get(position);
        holder.titleDokumentTV.setText(model.getdokument_name());
        holder.dokumentIV.setImageResource(model.getdokument_image());

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDocDialog(model.getdokument_name(),"Lorem ipsum",model.getdokument_fach(),model.getDokument_typ(),model.getDokument_klasse(),"1000");
            }
        });

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

        private final Button editButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dokumentIV = itemView.findViewById(R.id.image_cardview);
            titleDokumentTV = itemView.findViewById(R.id.author_pl);
            editButton=itemView.findViewById(R.id.editButton);
        }
    }


    public void showEditDocDialog(String pDocTitle, String pDocDescription, String pFach, String pTyp, String pStufe, String pPreis){
        Dialog dialog= new Dialog(context);

        dialog.setContentView(R.layout.edit_document_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Button dismissButton=dialog.findViewById(R.id.dismissButton);
        EditText titleET=dialog.findViewById(R.id.docTitle);
        EditText description=dialog.findViewById(R.id.DescriptionET);
        EditText fach=dialog.findViewById(R.id.fach);
        EditText typ=dialog.findViewById(R.id.typ);
        EditText stufe=dialog.findViewById(R.id.stufe);
        EditText preis=dialog.findViewById(R.id.preis);

        titleET.setText(pDocTitle);
        description.setText(pDocDescription);
        fach.setText(pFach);
        typ.setText(pTyp);
        stufe.setText(pStufe);
        preis.setText(pPreis);

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
