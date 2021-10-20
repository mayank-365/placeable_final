package com.example.placeable_final;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class company extends Fragment {
    View view;
    Button reg_comp;
    Button open_comp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_company, container, false);

        reg_comp = view.findViewById(R.id.registered_comp);
        open_comp = view.findViewById(R.id.open_companies);

        reg_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.companyframe,new registered_companies(),"REGISTERED_COMPANIES");
                fragmentTransaction.addToBackStack("REGISTERED_COMPANIES");
                fragmentTransaction.commit();
            }
        });
        open_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.companyframe,new open_companies(),"OPEN_COMPANIES");
                fragmentTransaction.addToBackStack("OPEN_COMPANIES");
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}