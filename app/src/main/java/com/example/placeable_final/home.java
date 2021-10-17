package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Button viewprofile;
        Animation scaleup,scaledown;

            viewprofile=findViewById(R.id.view_complete_profile);
            scaleup= AnimationUtils.loadAnimation(this,R.anim.scale_up);
            scaledown= AnimationUtils.loadAnimation(this,R.anim.scale_down);

            viewprofile.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent motionEvent) {
                    if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                        viewprofile.startAnimation(scaleup);
                        Intent intent=new Intent(home.this,profile.class);
                        startActivity(intent);
                    }
                    else if(motionEvent.getAction()== MotionEvent.ACTION_UP){
                        viewprofile.startAnimation(scaledown);
                    }

                    return true;
                }
            });

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); getSupportActionBar().setDisplayShowCustomEnabled(
                    true
            );
            getSupportActionBar().setCustomView(R.layout.actionbar);
            View view =getSupportActionBar().getCustomView();
            ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);
            imageButton.setOnClickListener(
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


        /*BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_bar);
        bottomNavigationView.setSelectedItemId(R.id.home_nav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.company:
                        startActivity(new Intent(getApplicationContext(), company.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home_nav:
                        return true;
                    case R.id.profile_nav:
                        startActivity(new Intent(getApplicationContext(), profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });*/
    }

