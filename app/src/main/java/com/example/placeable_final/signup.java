package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    Button signin,register,cancel;
    ImageButton back;
    Animation scaleup,scaledown;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signin = findViewById(R.id.register_signin);
        back = findViewById(R.id.register_back_button);
        register = findViewById(R.id.register_request);
        cancel = findViewById(R.id.register_cancel);
        scaleup = AnimationUtils.loadAnimation(signup.this, R.anim.scale_up);
        scaledown = AnimationUtils.loadAnimation(signup.this, R.anim.scale_down);
        signin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    signin.startAnimation(scaleup);
                    Intent intent = new Intent(signup.this, MainActivity.class);
                    startActivity(intent);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    signin.startAnimation(scaledown);
                }

                return true;
            }
        });

        register.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    register.startAnimation(scaleup);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    register.startAnimation(scaledown);
                }

                return true;
            }
        });
        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back.startAnimation(scaleup);
                    Intent intent = new Intent(signup.this, MainActivity.class);
                    startActivity(intent);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    back.startAnimation(scaledown);
                }

                return true;
            }
        });
        cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    back.startAnimation(scaleup);
                    Intent intent = new Intent(signup.this, MainActivity.class);
                    startActivity(intent);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    back.startAnimation(scaledown);
                }
                return true;
            }
        });
    }
}
