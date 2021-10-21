package com.example.placeable_final;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class basic_detail extends Fragment  {
    View view;
    Button Next, cancel;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_basic_detail, container, false);

        //
        final Calendar myCalendar= Calendar.getInstance();
        Next=view.findViewById(R.id.basic_details_next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    acadmeics_details adetails=new acadmeics_details();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment1,new acadmeics_details(),"ACADEMIC_DETAILS");
                    fragmentTransaction.addToBackStack("ACADEMIC_DETAILS");
                    fragmentTransaction.commit();
                }


        });
        cancel = view.findViewById(R.id.basic_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment1,new main_fragment(),"MAIN_FRAGMENT");
                fragmentTransaction.commit();
            }
        });
       EditText edittext= (EditText)view.findViewById(R.id.Basic_details_dob);
       DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

           @Override
           public void onDateSet(DatePicker view, int year, int monthOfYear,
                                 int dayOfMonth) {
               // TODO Auto-generated method stub
               myCalendar.set(Calendar.YEAR, year);
               myCalendar.set(Calendar.MONTH, monthOfYear);
               myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
               updateLabel(myCalendar);
           }

       };

       edittext.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               // TODO Auto-generated method stub
               new DatePickerDialog(getContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
           }
       });
       //

        return view;
   }
    private void updateLabel(Calendar myCalendar) {
        String myFormat = "dd/yy/MM";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        EditText edittext=view.findViewById(R.id.Basic_details_dob);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }
}