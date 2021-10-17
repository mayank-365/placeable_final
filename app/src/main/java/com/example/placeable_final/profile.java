package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class profile extends AppCompatActivity {
    ConstraintLayout expandableView,expandable_academics;
    Button basicDetails,academicsdetails;
    CardView cardView,cardView_academics;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        expandableView=findViewById(R.id.expandabletext);
        basicDetails=findViewById(R.id.Basic_details);
        cardView=findViewById(R.id.profile_cardview);
        expandable_academics=findViewById(R.id.expandabletext_academics);
        academicsdetails=findViewById(R.id.profile_academics_details);
        cardView_academics=findViewById(R.id.profile_academics_cardview);
        basicDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                }
                else{

                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                }

            }
        });
        academicsdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandable_academics.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandable_academics.setVisibility(View.VISIBLE);
                }
                else{

                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandable_academics.setVisibility(View.GONE);
                }

            }
        });
    }
}
