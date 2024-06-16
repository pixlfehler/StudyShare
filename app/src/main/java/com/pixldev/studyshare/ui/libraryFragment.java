package com.pixldev.studyshare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pixldev.studyshare.Dokumenteadapter;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;

import java.util.ArrayList;

public class libraryFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public libraryFragment() {
        // Required empty public constructor
    }

    public static libraryFragment newInstance(String param1, String param2) {
        libraryFragment fragment = new libraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        RecyclerView meinedokumenteRV = view.findViewById(R.id.RVmeinedokumente);
        meinedokumenteRV.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Dokumentmodel> dokumentmodelArrayList = new ArrayList<>();
        dokumentmodelArrayList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe", "7", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder, true));
        dokumentmodelArrayList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder, true));

        Dokumenteadapter dokumentAdapter = new Dokumenteadapter(getContext(), dokumentmodelArrayList);
        meinedokumenteRV.setAdapter(dokumentAdapter);

        return view;
    }
}
