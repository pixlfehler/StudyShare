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

import com.pixldev.studyshare.ui.UserDetailFragment;

import java.util.ArrayList;

public class Freundeadapter extends RecyclerView.Adapter<Freundeadapter.ViewHolder> {

    private final ArrayList<Freundemodel> freundeModelArrayList;
    private final Context context;

    public Freundeadapter(Context context, ArrayList<Freundemodel> freundeModelArrayList) {
        this.context = context;
        this.freundeModelArrayList = freundeModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_freunde_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Freundemodel model = freundeModelArrayList.get(position);
        holder.nameTV.setText(model.getname()+" ("+model.getUsername()+")");
        holder.stufeTV.setText(model.getstufe());
        holder.freundeThumbnailIV.setImageResource(model.getfreunde_thumbnail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    @Override
    public int getItemCount() {
        return freundeModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView freundeThumbnailIV;
        private final TextView nameTV;
        private final TextView stufeTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            freundeThumbnailIV = itemView.findViewById(R.id.anfragen_thumbnail);
            nameTV = itemView.findViewById(R.id.name);
            stufeTV = itemView.findViewById(R.id.docCount);
        }
    }
}
