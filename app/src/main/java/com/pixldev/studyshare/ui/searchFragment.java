package com.pixldev.studyshare.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputLayout;
import com.pixldev.studyshare.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link searchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class searchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public searchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment searchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static searchFragment newInstance(String param1, String param2) {
        searchFragment fragment = new searchFragment();
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


        View view1= inflater.inflate(R.layout.fragment_search, container, false);

        EditText searchET = view1.findViewById(R.id.searchET);
        TextInputLayout inputLayout=view1.findViewById(R.id.textInputLayout);
        MaterialButtonToggleGroup toggleGroup = view1.findViewById(R.id.ToggleGroup);

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Vor dem Textwechsel - hier nicht benötigt
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Während des Textwechsels - hier nicht benötigt
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nachdem der Text geändert wurde
                if (s.length() > 0) {
                    // Text ist vorhanden, ToggleGroup sichtbar machen
                    toggleGroup.setVisibility(View.VISIBLE);

                } else {
                    // Kein Text, ToggleGroup unsichtbar machen
                    toggleGroup.setVisibility(View.GONE);
                }
            }
        });

        return view1;
    }
}