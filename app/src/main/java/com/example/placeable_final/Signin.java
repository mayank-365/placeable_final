package com.example.placeable_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends Fragment {
    View view,signin,forget,register;
    private EditText Email,Password;
    private Button Sign_In,Forget_Password,Register;
    private FirebaseAuth firebaseAuth;
    @SuppressLint("CutPasteId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_signin, container, false);
        Email = (EditText)view.findViewById(R.id.Email);
        Password = (EditText)view.findViewById(R.id.Password);
        Sign_In = (Button)view.findViewById(R.id.button_signin);
        Forget_Password = view.findViewById(R.id.forgetpassword);
        Register = view.findViewById(R.id.notregister);
        firebaseAuth = FirebaseAuth.getInstance();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),sign_up.class));
            }
        });
        Sign_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){
                    Toast.makeText(getContext(),"All Fields Required",Toast.LENGTH_SHORT).show();
                }else{
                    login(email,password);
                }
            }
        });
        //button code start
        Animation scaleup,scaledown;
        scaleup= AnimationUtils.loadAnimation(getContext(),R.anim.scale_up);
        scaledown = AnimationUtils.loadAnimation(getContext(),R.anim.scale_down);


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
    private void login(String email,String password){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(getContext(),home.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}