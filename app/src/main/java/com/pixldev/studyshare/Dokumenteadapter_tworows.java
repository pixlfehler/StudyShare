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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dokument_tworows_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dokumenteadapter_tworows.ViewHolder holder, int position) {
        Dokumentmodel model = dokumentModelArrayList.get(position);
        holder.titleDokumentTV.setText(model.getdokument_name());
        holder.dokumentIV.setImageResource(model.getdokument_image());

        // Editieren-Button onClickListener
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDocDialog(model.getdokument_name(), "Lorem ipsum", model.getdokument_fach(), model.getDokument_typ(), model.getDokument_klasse(), "1000");
            }
        });

        // Item onClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Neues DetailFragment erzeugen
                Fragment newFragment = new detailFragment();

                // Argumente für das Fragment setzen
                Bundle args = new Bundle();
                args.putString("title", model.getdokument_name());
                args.putString("fach", model.getdokument_fach());
                args.putString("typ", model.getDokument_typ());
                args.putString("stufe", model.getDokument_klasse());
                args.putInt("image", model.getdokument_image());
                args.putBoolean("blur",false);;
                args.putParcelableArrayList("comments", model.getComments());

                // Argumente dem Fragment übergeben
                newFragment.setArguments(args);

                // FragmentManager und FragmentTransaction für die Fragmenttransaktion initialisieren
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Fragment ersetzen und der BackStack hinzufügen
                fragmentTransaction.replace(R.id.nav_host_fragment, newFragment);
                fragmentTransaction.addToBackStack(null); // Optional: um den Fragment-Wechsel rückgängig machen zu können

                // Fragmenttransaktion durchführen
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
            dokumentIV = itemView.findViewById(R.id.thumbnailIV);
            titleDokumentTV = itemView.findViewById(R.id.author_pl);
            editButton = itemView.findViewById(R.id.editButton);
        }
    }

    // Methode zur Anzeige des Dialogs zur Bearbeitung des Dokuments
    public void showEditDocDialog(String pDocTitle, String pDocDescription, String pFach, String pTyp, String pStufe, String pPreis) {
        // Dialog initialisieren
        Dialog dialog = new Dialog(context);

        // Layout des Dialogs setzen
        dialog.setContentView(R.layout.edit_document_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // Views im Dialog initialisieren
        Button dismissButton = dialog.findViewById(R.id.dismissButton);
        EditText titleET = dialog.findViewById(R.id.docTitle);
        EditText description = dialog.findViewById(R.id.DescriptionET);
        EditText fach = dialog.findViewById(R.id.stufe);
        EditText typ = dialog.findViewById(R.id.friendCount);
        EditText stufe = dialog.findViewById(R.id.docCount);
        EditText preis = dialog.findViewById(R.id.preis);

        // Textfelder mit den übergebenen Werten füllen
        titleET.setText(pDocTitle);
        description.setText(pDocDescription);
        fach.setText(pFach);
        typ.setText(pTyp);
        stufe.setText(pStufe);
        preis.setText(pPreis);

        // Dismiss-Button OnClickListener setzen
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dialog schließen
                dialog.dismiss();
            }
        });

        // Dialog anzeigen
        dialog.show();
    }
}
