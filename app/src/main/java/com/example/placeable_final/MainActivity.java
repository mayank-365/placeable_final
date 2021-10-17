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
import android.os.Bundle;
import android.os.PersistableBundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Button signin;
    Animation scaleup,scaledown;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_signin);
        //animation button
        signin=findViewById(R.id.button_signin);
        scaleup= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_up);
        scaledown = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_down);

        signin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    signin.startAnimation(scaleup);
                    Intent intent=new Intent(MainActivity.this,home.class);
                    startActivity(intent);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    signin.startAnimation(scaledown);
                }

                return true;
            }
        });
        //animation code end


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,home.class);
                startActivity(intent);
            }
        });

    }
}
