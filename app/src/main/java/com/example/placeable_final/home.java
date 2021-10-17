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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(
                true
        );
        getSupportActionBar().setCustomView(R.layout.actionbar);
        View view = getSupportActionBar().getCustomView();
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.action_bar_back);
        imageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.action_bar_forward);
        imageButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),
                                "Forward Button is clicked"
                                , Toast.LENGTH_LONG).show();
                    }
                });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment1,new main_fragment(),"MAIN_FRAGMENT");
        fragmentTransaction.commit();

        View back_btn=(ImageButton) view.findViewById(R.id.action_bar_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f=getActiveFragment();
                if(f instanceof studentProfile)  {
                    main_fragment mainFrag = new main_fragment();
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment1, mainFrag,"MAIN_FRAGMENT");
                    fragmentTransaction.addToBackStack("MAIN_FRAGMENT");
                    fragmentTransaction.commit();
                }
                else if(f==null || f instanceof main_fragment)
                {
                    finish();
                }

            }
        });
    }
    public Fragment getActiveFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return null;
        }
        String tag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        return (Fragment) getSupportFragmentManager().findFragmentByTag(tag);
    }
}
