package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class acadmeics_details extends Fragment {
    View view;
    Button next,back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_acadmeics_details, container, false);
        next=view.findViewById(R.id.academics_nextbutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additional_details adetails=new additional_details();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment1,new additional_details(),"ADDITIONAL_DETAILS");
                fragmentTransaction.addToBackStack("ADDITIONAL_DETAILS");
                fragmentTransaction.commit();
            }
        });
        back=view.findViewById(R.id.academics_details_backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment1,new main_fragment(),"MAIN_FRAGMENT");
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}