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

public class searchFragment extends Fragment {



    public searchFragment() {
        // Required empty public constructor
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