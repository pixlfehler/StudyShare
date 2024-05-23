package com.pixldev.studyshare.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        RecyclerView courseRV = view.findViewById(R.id.RVdokument);

        // Here, we have created new array list and added data to it
        ArrayList<Dokumentmodel> dokumentmodelArrayList = new ArrayList<Dokumentmodel>();
        dokumentmodelArrayList.add(new Dokumentmodel("DSA in Java", "Bio", R.drawable.logo_placeholder));
        dokumentmodelArrayList.add(new Dokumentmodel("Java Course", "Bio", R.drawable.logo_placeholder));
        dokumentmodelArrayList.add(new Dokumentmodel("C++ Course", "Bio", R.drawable.logo_placeholder));
        dokumentmodelArrayList.add(new Dokumentmodel("DSA in C++", "Bio", R.drawable.logo_placeholder));
        dokumentmodelArrayList.add(new Dokumentmodel("Kotlin for Android", "Bio", R.drawable.logo_placeholder));
        dokumentmodelArrayList.add(new Dokumentmodel("Java for Android", "Bio", R.drawable.logo_placeholder));
        dokumentmodelArrayList.add(new Dokumentmodel("HTML and CSS", "Bio", R.drawable.logo_placeholder));

        // we are initializing our adapter class and passing our arraylist to it.
        Dokumenteadapter courseAdapter = new Dokumenteadapter(getContext(), dokumentmodelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);

        return view;
    }
}