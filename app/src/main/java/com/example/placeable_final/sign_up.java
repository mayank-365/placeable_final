package com.example.placeable_final;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Objects;

public class sign_up extends Fragment {
    private EditText First_Name,Last_Name,Reg_No,Phone_No,Email_Id,Password,Confirm_Password ;
    private Button Register,Sign_in,Cancel;
    private FirebaseAuth firebaseAuth;
    View view ;
    ProgressBar progressBar;
    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        First_Name = (EditText) view.findViewById(R.id.signup_First_Name);
        Last_Name = view.findViewById(R.id.signup_Last_Name);
        Reg_No = view.findViewById(R.id.register_register_no);
        Phone_No = view.findViewById(R.id.register_phone_no);
        Email_Id = view.findViewById(R.id.register_email);
        Password = view.findViewById(R.id.register_password);
        Confirm_Password = view.findViewById(R.id.register_confirm_password);
        Register = view.findViewById(R.id.register_request);
        Sign_in = view.findViewById(R.id.register_signin);
        Cancel = view.findViewById(R.id.register_cancel);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String first_name = First_Name.getText().toString();
                final String last_name = Last_Name.getText().toString();
                final String reg_no = Reg_No.getText().toString();
                final String phone_no = Phone_No.getText().toString();
                final String email_id = Email_Id.getText().toString();
                final String password = Password.getText().toString();
                final String confirm_password = Confirm_Password.getText().toString();
                if(TextUtils.isEmpty(first_name)||TextUtils.isEmpty(last_name)||TextUtils.isEmpty(reg_no)||TextUtils.isEmpty(phone_no)||TextUtils.isEmpty(email_id)||TextUtils.isEmpty(password)||TextUtils.isEmpty(confirm_password)){
                    Toast.makeText(getContext(),"All fields are required",Toast.LENGTH_SHORT).show();
                }else{
                    register(first_name,last_name,reg_no,phone_no,email_id,password,confirm_password);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    private void register(String first_name,String last_name,String reg_no,String phone_no,String email_id,String password,String confirm_password){
        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email_id,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser rUser = firebaseAuth.getCurrentUser();
                    String userId = rUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
                    HashMap<String,String> hashMap= new HashMap<>();
                    hashMap.put("userId",userId);
                    hashMap.put("First Name", first_name);
                    hashMap.put("Last Name", last_name);
                    hashMap.put("Registration Number", reg_no);
                    hashMap.put("Phone Number", phone_no);
                    hashMap.put("Email Id", email_id);
                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                progressBar.setVisibility(view.GONE);
                                Intent intent = new Intent(getContext(),home.class);
                                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getContext(), Objects.requireNonNull(task.getException().getMessage()),Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }else{
                    progressBar.setVisibility(view.GONE);
                    Toast.makeText(getContext(), Objects.requireNonNull(task.getException().getMessage()),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

