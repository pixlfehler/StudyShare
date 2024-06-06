package com.pixldev.studyshare.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pixldev.studyshare.Dokumenteadapter;
import com.pixldev.studyshare.Dokumentmodel;
import com.pixldev.studyshare.KommentarAdapter;
import com.pixldev.studyshare.KommentarModel;
import com.pixldev.studyshare.R;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ArrayList<KommentarModel> commentArrayList;

    public detailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment detailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static detailFragment newInstance(String param1, String param2) {
        detailFragment fragment = new detailFragment();
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
        View view= inflater.inflate(R.layout.fragment_detail, container, false);

        Button commentButton=view.findViewById(R.id.commentButton);

        commentArrayList = new ArrayList<KommentarModel>();

        TextView docTitle=view.findViewById(R.id.DocumentTitle);
        TextView docFach=view.findViewById(R.id.Fach);
        TextView docTyp=view.findViewById(R.id.Typ);
        TextView docStufe=view.findViewById(R.id.Stufe);

        ImageView thumbnailIV=view.findViewById(R.id.thumbnailIV);

        if(getArguments()!=null) {
            docTitle.setText(getArguments().getString("title"));
            docFach.setText(getArguments().getString("fach"));
            docTyp.setText(getArguments().getString("typ"));
            docStufe.setText(getArguments().getString("stufe"));

            thumbnailIV.setImageResource(getArguments().getInt("image"));

            commentArrayList=getArguments().getParcelableArrayList("comments");
        }


        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.comment_bottom_sheet, null);
                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();

                RecyclerView commentRV = view1.findViewById(R.id.commentRV);

                // Here, we have created new array list and added data to it


                commentArrayList.add(new KommentarModel("pixlfehler","Was ist das denn für ein Müll! Was ist das denn für ein Müll! Was ist das denn für ein Müll! Was ist das denn für ein Müll!",1));
                commentArrayList.add(new KommentarModel("jappez","Super!",4));
                commentArrayList.add(new KommentarModel("AnonymerNutzer123","yoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyoyo"));
                commentArrayList.add(new KommentarModel("Bot77","Ich mags!",5));
                commentArrayList.add(new KommentarModel("Boris Meltzow","Diese Kommentare sind ja so cool!👁️👁️",4));

                // we are initializing our adapter class and passing our arraylist to it.
                KommentarAdapter commentAdapter = new KommentarAdapter(getContext(), commentArrayList);

                // below line is for setting a layout manager for our recycler view.
                // here we are creating vertical list so we will provide orientation as vertical
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                // in below two lines we are setting layoutmanager and adapter to our recycler view.
                commentRV.setLayoutManager(linearLayoutManager);
                commentRV.setAdapter(commentAdapter);

            }
        });


        return view;
    }
}