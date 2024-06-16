package com.pixldev.studyshare.ui;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pixldev.studyshare.Dokumenteadapter;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView courseRV = view.findViewById(R.id.RVmeinedokumente);

        FloatingActionButton newDocButton=view.findViewById(R.id.newDocButton);

        // Here, we have created new array list and added data to it
        ArrayList<Dokumentmodel> dokumentmodelArrayList = new ArrayList<Dokumentmodel>();
        dokumentmodelArrayList.add(new Dokumentmodel("Übungszettel Genetik", "Bio", "Lernzettel","EF", R.drawable.document_placeholder,true));
        dokumentmodelArrayList.add(new Dokumentmodel("Eigene Aufgaben zu Lyrik", "Deutsch", "Übungsaufgabe","7", R.drawable.document_placeholder,false));
        dokumentmodelArrayList.add(new Dokumentmodel("Vokabeln für Französisch Test", "Französisch", "Lernzettel", "EF", R.drawable.document_placeholder,false));
        dokumentmodelArrayList.add(new Dokumentmodel("Mathematik Übungsaufgaben", "Mathematik", "Übungsaufgabe", "Q1", R.drawable.document_placeholder,false));
        dokumentmodelArrayList.add(new Dokumentmodel("Geschichtsreferat über Mittelalter", "Geschichte", "Referat", "Q2", R.drawable.document_placeholder,false));
        dokumentmodelArrayList.add(new Dokumentmodel("Chemie Laborbericht", "Chemie", "Laborbericht", "EF", R.drawable.document_placeholder,false));
        dokumentmodelArrayList.add(new Dokumentmodel("Englisch Essay zu Shakespeare", "Englisch", "Essay", "Q1", R.drawable.document_placeholder,false));


        // we are initializing our adapter class and passing our arraylist to it.
        Dokumenteadapter courseAdapter = new Dokumenteadapter(getContext(), dokumentmodelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);

        newDocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewDocDialog();
            }
        });



        return view;
    }

    public void showConfirmTransactionDialog(){
        Dialog dialog= new Dialog(getContext());

        dialog.setContentView(R.layout.yes_no_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView heading=dialog.findViewById(R.id.heading);
        heading.setText("Test");

        dialog.show();
    }

    public void showNewDocDialog(){
        Dialog dialog= new Dialog(getContext());

        dialog.setContentView(R.layout.new_document_dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Button dismissButton=dialog.findViewById(R.id.freundablehnen);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}