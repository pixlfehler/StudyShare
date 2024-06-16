package com.pixldev.studyshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class KommentarAdapter extends RecyclerView.Adapter<KommentarAdapter.ViewHolder> {

    private final ArrayList<KommentarModel> kommentarModelArrayList;
    private final Context context;

    // Constructor
    public KommentarAdapter(Context context, ArrayList<KommentarModel> kommentarModelArrayList) {
        this.context = context;
        this.kommentarModelArrayList = kommentarModelArrayList;
    }

    @NonNull
    @Override
    public KommentarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout für jedes Item des RecyclerViews aufblähen.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_comment_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KommentarAdapter.ViewHolder holder, int position) {
        // Daten an die Views im ViewHolder binden.
        KommentarModel model = kommentarModelArrayList.get(position);
        holder.authorTextView.setText(model.getAuthor());
        holder.contentTextView.setText(model.getContent());

        // Bewertung anzeigen oder RatingBar verbergen
        if (model.getBewertung() == null || model.getBewertung() < 1 || model.getBewertung() > 5) {
            holder.ratingBar.setVisibility(View.INVISIBLE);
        } else {
            holder.ratingBar.setRating(model.getBewertung());
        }
    }

    @Override
    public int getItemCount() {
        // Anzahl der Items im RecyclerView zurückgeben.
        return kommentarModelArrayList.size();
    }

    // ViewHolder-Klasse zur Initialisierung der Views.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView authorTextView;
        private final TextView contentTextView;
        private final RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            authorTextView = itemView.findViewById(R.id.author_pl);
            contentTextView = itemView.findViewById(R.id.content_pl);
            ratingBar = itemView.findViewById(R.id.rating_pl);
        }
    }
}
