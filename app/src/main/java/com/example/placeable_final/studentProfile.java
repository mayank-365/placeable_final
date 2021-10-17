package com.example.placeable_final;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class studentProfile extends Fragment {
    View view;

    ConstraintLayout expandableView,expandable_academics;
    CardView cardView,cardView_academics;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_student_profile, container, false);

        View basicDetails=(Button) view.findViewById(R.id.Basic_details);
        expandableView=view.findViewById(R.id.expandabletext);
        cardView=view.findViewById(R.id.profile_cardview);
        expandable_academics=view.findViewById(R.id.expandabletext_academics);
        cardView_academics=view.findViewById(R.id.profile_academics_cardview);
        basicDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    expandable_academics.setVisibility(View.GONE);
                }
                else{
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }
}