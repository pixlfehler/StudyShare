package com.pixldev.studyshare.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pixldev.studyshare.AnfragenFregment;
import com.pixldev.studyshare.FreundeFragment;
import com.pixldev.studyshare.NewsFragment;
import com.pixldev.studyshare.R;

public class interactionsFragment extends Fragment {
    public boolean erstesmal= true;

    public interactionsFragment() {
        // Required empty public constructor
    }

    public static interactionsFragment newInstance(String param1, String param2) {
        interactionsFragment fragment = new interactionsFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param1");
            String mParam2 = getArguments().getString("param2");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interactions, container, false);

        // Initialize buttons
        Button buttonFreunde = view.findViewById(R.id.buttonFreunde);
        Button buttonFreundeFinden = view.findViewById(R.id.button2);
        Button buttonneues = view.findViewById(R.id.button3);
        if(erstesmal){loadFragment(new FreundeFragment());erstesmal=false;}

        buttonFreunde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FreundeFragment());
            }
        });

        buttonFreundeFinden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AnfragenFregment());
            }
        });

        buttonneues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NewsFragment());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

