package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class Signin extends Fragment {
    View view,signin,forget,register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_signin, container, false);

        //button code start
        Animation scaleup,scaledown;
        scaleup= AnimationUtils.loadAnimation(getContext(),R.anim.scale_up);
        scaledown = AnimationUtils.loadAnimation(getContext(),R.anim.scale_down);
        signin=(Button)view.findViewById(R.id.button_signin);
        signin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    signin.startAnimation(scaleup);
                    Intent intent = new Intent(getContext(),home.class);
                    startActivity(intent);
//                    sign_up signup = new sign_up();
//                    FragmentManager fragmentManager = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.main_activity_frame,new sign_up(),"Sign Up");
//                    fragmentTransaction.addToBackStack("Sign Up");
//                    fragmentTransaction.commit();
                }
                else if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                    signin.startAnimation(scaledown);
                }
                return true;
            }
        });

        forget=(Button)view.findViewById(R.id.forgetpassword);
        forget.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    forget.startAnimation(scaleup);
                    forget forget = new forget();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main_activity_frame,new forget(),"Forget");
                    fragmentTransaction.addToBackStack("Forget");
                    fragmentTransaction.commit();
                }
                else if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                    forget.startAnimation(scaledown);
                }
                return true;
            }
        });
        register=(Button)view.findViewById(R.id.notregister);
        register.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    register.startAnimation(scaleup);
                    sign_up signup = new sign_up();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.main_activity_frame,new sign_up(),"Sign Up");
                    fragmentTransaction.addToBackStack("Sign Up");
                    fragmentTransaction.commit();
                }
                else if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                    register.startAnimation(scaledown);
                }
                return true;
            }
        });
        //button code end
        return view;
    }
}