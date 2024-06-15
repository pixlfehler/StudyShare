package com.pixldev.studyshare.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pixldev.studyshare.Dokumenteadapter;
import com.pixldev.studyshare.Dokumenteadapter_tworows;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link accountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class accountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public accountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment accountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static accountFragment newInstance(String param1, String param2) {
        accountFragment fragment = new accountFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_account, null);

        RecyclerView recyclerView = view1.findViewById(R.id.dokumentRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // Zwei Spalten

        ArrayList<Dokumentmodel> itemList = new ArrayList<>();

        itemList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel","EF", R.drawable.document_placeholder,true));
        itemList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe","7", R.drawable.document_placeholder,false));
        itemList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder,false));
        itemList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder,false));
        itemList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder,false));
        itemList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder,false));
        itemList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder,false));
        // Füge Daten zur itemList hinzu

        Dokumenteadapter_tworows adapter = new Dokumenteadapter_tworows(getContext(), itemList);
        recyclerView.setAdapter(adapter);

        return view1;
    }
}