package com.pixldev.studyshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BenachrichtigungenFregment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.news_interaction_fragment, container, false);
        RecyclerView benachrichtigungenRV = view.findViewById(R.id.BenachrichtigungenRV);

        benachrichtigungenRV.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Benachrichtigungsmodel> BenachrichtigungsmodelArrayList = new ArrayList<>();
        BenachrichtigungsmodelArrayList.add(new Benachrichtigungsmodel("Kauf", "Fabian kauft dein dokument für "));
        BenachrichtigungsmodelArrayList.add(new Benachrichtigungsmodel("Person 2", "Stufe 2"));
        BenachrichtigungsmodelArrayList.add(new Benachrichtigungsmodel("Person 3", "Stufe 3"));

        Benachrichtigungsadapter Benachrichtigungsadapter = new Benachrichtigungsadapter(getContext(), BenachrichtigungsmodelArrayList);
        benachrichtigungenRV.setAdapter(Benachrichtigungsadapter);
        return view;
    }
}
