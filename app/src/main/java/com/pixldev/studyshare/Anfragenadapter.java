package com.pixldev.studyshare;

import static com.airbnb.lottie.L.TAG;

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

    private final ArrayList<Anfragenmodel> anfragenModelArrayList;
    private final Context context;
    private static final String TAG = "Anfragenadapter";

    public Anfragenadapter(Context context, ArrayList<Anfragenmodel> anfragenModelArrayList) {
        this.context = context;
        this.anfragenModelArrayList = anfragenModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_anfragen_recyclerview, parent, false);
        Button ablehen = view.findViewById(R.id.freundablehnen);
        Button annehmen = view.findViewById(R.id.freundannehmen);
            ablehen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "abgelehnt");
                }
            });
            annehmen.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Log.d(TAG, "angemommen");
                }
            });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Anfragenmodel model = anfragenModelArrayList.get(position);
        holder.nameTV.setText(model.getnameanfarge());
        holder.stufeTV.setText(model.getstufeanfarge());
        holder.anfragenThumbnailIV.setImageResource(model.getanfarge_thumbnail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new detailFragment();

                Bundle args = new Bundle();
                args.putString("name", model.getnameanfarge());
                args.putString("stufe", model.getstufeanfarge());
                args.putInt("anfragen_thumbnail", model.getanfarge_thumbnail());

                newFragment.setArguments(args);

                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, newFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return anfragenModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView anfragenThumbnailIV;
        private final TextView nameTV;
        private final TextView stufeTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anfragenThumbnailIV = itemView.findViewById(R.id.anfragen_thumbnail);
            nameTV = itemView.findViewById(R.id.name);
            stufeTV = itemView.findViewById(R.id.stufe);
        }
    }
}

