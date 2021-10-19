package com.example.placeable_final;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Animation scaleup,scaledown;
    ImageButton back;
    View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        //animation button
        scaleup= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_up);
        scaledown = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_down);
        back=findViewById(R.id.main_activity_back);

        //back button ontouch
        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    back.startAnimation(scaleup);
                    finish();
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    back.startAnimation(scaledown);
                }

                return true;
            }
        });

        //signin fun on touch

        //animation code end


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_frame,new Signin(),"Signin");
        fragmentTransaction.commit();
//
//        View back_btn=(ImageButton) view.findViewById(R.id.action_bar_back);
//        back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment f=getActiveFragment();
//                if(f instanceof studentProfile)  {
//                    main_fragment mainFrag = new main_fragment();
//                    FragmentManager fragmentManager1 = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
//                    fragmentTransaction.replace(R.id.main_activity_frame, mainFrag,"MAIN_FRAGMENT");
//                    fragmentTransaction.addToBackStack("MAIN_FRAGMENT");
//                    fragmentTransaction.commit();
//                }
//                else if(f==null || f instanceof main_fragment)
//                {
//                    finish();
//                }
//
//            }
//        });

    }

    public Fragment getActiveFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return null;
        }
        String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        return (Fragment) getSupportFragmentManager().findFragmentByTag(tag);
    }
}

//
//public class MainActivity extends AppCompatActivity {
//    Button signin,register;
//    ImageButton back;
//    Animation scaleup,scaledown;
//    View view;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.student_signin);
//        //animation button
//        signin=findViewById(R.id.button_signin);
//        scaleup= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_up);
//        scaledown = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_down);
//        register = findViewById(R.id.notregister);
//        back=findViewById(R.id.signin_back);
//
//        //back button ontouch
//        back.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent motionEvent) {
//                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
//                    back.startAnimation(scaleup);
//                    finish();
//                }
//                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
//                    back.startAnimation(scaledown);
//                }
//
//                return true;
//            }
//        });
//
//        //signin fun on touch
//        signin.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent motionEvent) {
//                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
//                    signin.startAnimation(scaleup);
//                    Intent intent=new Intent(MainActivity.this,home.class);
//                    startActivity(intent);
//                }
//                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
//                    signin.startAnimation(scaledown);
//                }
//
//                return true;
//            }
//        });
//
//        //register fun on touch
//        register.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent motionEvent) {
//                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
//                    register.startAnimation(scaleup);
//                    Intent intent=new Intent(MainActivity.this,signup.class);
//                    startActivity(intent);
//                }
//                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
//                    register.startAnimation(scaledown);
//                }
//
//                return true;
//            }
//        });
//        //animation code end
//
//
//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,home.class);
//                startActivity(intent);
//            }
//        });
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment1,new main_fragment(),"MAIN_FRAGMENT");
//        fragmentTransaction.commit();
//
//        View back_btn=(ImageButton) view.findViewById(R.id.action_bar_back);
//        back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment f=getActiveFragment();
//                if(f instanceof studentProfile)  {
//                    main_fragment mainFrag = new main_fragment();
//                    FragmentManager fragmentManager1 = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragment1, mainFrag,"MAIN_FRAGMENT");
//                    fragmentTransaction.addToBackStack("MAIN_FRAGMENT");
//                    fragmentTransaction.commit();
//                }
//                else if(f==null || f instanceof main_fragment)
//                {
//                    finish();
//                }
//
//            }
//        });
//
//    }
//
//    public Fragment getActiveFragment() {
//        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
//            return null;
//        }
//        String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
//        return (Fragment) getSupportFragmentManager().findFragmentByTag(tag);
//    }
//}
