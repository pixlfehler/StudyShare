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

public class FreundeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.freunde_interaction_fragment, container, false);
        RecyclerView freundeRV = view.findViewById(R.id.FreundeRV);

        // Set LayoutManager for RecyclerView
        freundeRV.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Freundemodel> freundemodelArrayList = new ArrayList<>();
        freundemodelArrayList.add(new Freundemodel("Jasper", "7", R.drawable.sample_profile_pic));
        freundemodelArrayList.add(new Freundemodel("Herbert", "8", R.drawable.sample_profile_pic));
        freundemodelArrayList.add(new Freundemodel("Hannes", "9", R.drawable.sample_profile_pic));
        freundemodelArrayList.add(new Freundemodel("Sebastian", "9", R.drawable.sample_profile_pic));
        freundemodelArrayList.add(new Freundemodel("Lennox", "Q1", R.drawable.sample_profile_pic));
        freundemodelArrayList.add(new Freundemodel("Fabian", "EF", R.drawable.sample_profile_pic));
        freundemodelArrayList.add(new Freundemodel("Adrian", "EF", R.drawable.sample_profile_pic));

        Freundeadapter freundeAdapter = new Freundeadapter(getContext(), freundemodelArrayList);
        freundeRV.setAdapter(freundeAdapter);
        return view;
    }
}
