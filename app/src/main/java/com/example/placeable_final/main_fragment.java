package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class main_fragment extends Fragment {
    View view,viewprofile,clicktocompleteprofile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_main_fragment, container, false);
        //

            //...


                //
        viewprofile = (Button) view.findViewById(R.id.view_complete_profile);
        clicktocompleteprofile=(Button)view.findViewById(R.id.main_click_completeprofile);
        Animation scaleup,scaledown;
        scaleup= AnimationUtils.loadAnimation(getContext(),R.anim.scale_up);
        scaledown = AnimationUtils.loadAnimation(getContext(),R.anim.scale_down);

        viewprofile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    viewprofile.startAnimation(scaleup);
                    studentProfile student = new studentProfile();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment1, new studentProfile(), "STUDENT_PROFILE");
                    fragmentTransaction.addToBackStack("STUDENT_PROFILE");
                    fragmentTransaction.commit();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    viewprofile.startAnimation(scaledown);
                }
                return true;
            }

            });
                clicktocompleteprofile.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent motionEvent) {
                        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                            clicktocompleteprofile.startAnimation(scaleup);
                            basic_detail bdetails=new basic_detail();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment1,new basic_detail(),"BASIC_DETAILS");
                            fragmentTransaction.addToBackStack("BASIC_DETAILS");
                            fragmentTransaction.commit();
                        }
                        else if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                            viewprofile.startAnimation(scaledown);
                        }
                        return true;
                    }
        });
        return  view;



    }

}