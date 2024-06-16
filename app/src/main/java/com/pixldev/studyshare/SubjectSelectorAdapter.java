package com.pixldev.studyshare;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Arrays;


public class SubjectSelectorAdapter extends RecyclerView.Adapter<SubjectSelectorAdapter.SubjectViewHolder> {

    private final boolean[] selectionArray;
    private List<String> dataList;

    public SubjectSelectorAdapter(List<String> dataList) {
        this.dataList = dataList;

        this.selectionArray = new boolean[dataList.size()];
        Arrays.fill(this.selectionArray, false);
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_selectsubjects, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        String data = dataList.get(position);
        holder.textView.setText(data);

        // Setze den Hintergrund oder andere visuelle Eigenschaften basierend auf dem Auswahlstatus
        if (selectionArray[position]) {
            // Element ist ausgewählt
            holder.holderCV.setCardElevation(15);
        } else {
            // Element ist nicht ausgewählt
            holder.holderCV.setCardElevation(0);
        }

        // Füge den OnClickListener hinzu, um den Auswahlstatus zu ändern
        holder.itemView.setOnClickListener(v -> {
            // Umkehrung des aktuellen Auswahlstatus
            selectionArray[position] = !selectionArray[position];
            // Aktualisierung der Ansicht
            notifyItemChanged(position);

            // Hier kannst du zusätzliche Logik hinzufügen, wenn gewünscht
            // z.B. das Ausgewählt oder Abgewählt Rückmeldung geben
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView holderCV;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            holderCV= itemView.findViewById(R.id.holderCV);
            textView = itemView.findViewById(R.id.textView8);
        }
    }
}
