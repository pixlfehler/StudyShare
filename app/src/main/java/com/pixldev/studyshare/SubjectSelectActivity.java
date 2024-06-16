package com.pixldev.studyshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class SubjectSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_select);


        RecyclerView recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> data = Arrays.asList(
                "🌿 Biologie",
                "⚙️ Physik",
                "🔬 Chemie",
                "📐 Mathematik",
                "🖥️ Informatik",
                "🗺️ Geographie",
                "📚 Geschichte",
                "🎨 Kunst",
                "🎵 Musik",
                "🏛️ Sozialkunde",
                "📰 Deutsch",
                "🌍 Englisch",
                "🗣️ Fremdsprachen",
                "📝 Literatur",
                "🏊‍♂️ Sport",
                "🧪 Naturwissenschaften"
        );

        SubjectSelectorAdapter adapter = new SubjectSelectorAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}