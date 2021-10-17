package com.example.placeable_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
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
    Button viewprofile;
    Animation scaleup,scaledown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        viewprofile=findViewById(R.id.view_complete_profile);
        scaleup= AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaledown= AnimationUtils.loadAnimation(this,R.anim.scale_down);

        viewprofile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    viewprofile.startAnimation(scaleup);
                    Intent intent=new Intent(MainActivity.this,profile.class);
                    startActivity(intent);
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    viewprofile.startAnimation(scaledown);
                }

                return true;
            }
        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); getSupportActionBar().setDisplayShowCustomEnabled(
                true
        ); getSupportActionBar().setCustomView(R.layout.actionbar); View view =getSupportActionBar().getCustomView(); ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back); imageButton.setOnClickListener(
                new View.OnClickListener() {
                            @Override
                            public void onClick(View v)
                            { finish(); } }); ImageButton imageButton2= (ImageButton)view.findViewById(R.id.action_bar_forward); imageButton2.setOnClickListener(
                new View.OnClickListener() {
                            @Override
                            public void onClick(View v)
                            { Toast.makeText(getApplicationContext(),
                                    "Forward Button is clicked"
                                    ,Toast.LENGTH_LONG).show(); } });

    }
}