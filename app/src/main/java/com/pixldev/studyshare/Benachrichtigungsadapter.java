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

    private final ArrayList<Benachrichtigungsmodel> BenachrichtigungsmodelArrayList;
    private final Context context;

    public Benachrichtigungsadapter(Context context, ArrayList<Benachrichtigungsmodel> benachrichtigungsmodelArrayList) {
        this.context = context;
        this.BenachrichtigungsmodelArrayList = benachrichtigungsmodelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_benachrichtigungen_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Benachrichtigungsmodel model = BenachrichtigungsmodelArrayList.get(position);
        holder.artderbenachrichtigungTV.setText(model.getartderbenachrichtigung());
        holder.infotextTV.setText(model.getinfotext());
    }

    @Override
    public int getItemCount() {
        return BenachrichtigungsmodelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView artderbenachrichtigungTV;
        private final TextView infotextTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            artderbenachrichtigungTV = itemView.findViewById(R.id.artderbenachrichtigung);
            infotextTV = itemView.findViewById(R.id.infotext);
        }
    }
}
