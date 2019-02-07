package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientRegistration extends AppCompatActivity {
TextInputLayout firstnamelayout,lastnamelayout,agelayout,arealayout,emailidlayout,phonennumberlayout;
TextInputEditText first_ed_txt,last_ed_txt,age_edit_txt,area_ed_txt,email_ed_txt,phoneno_ed_txt;
RadioGroup radioGroup;
RadioButton radioButton1,radioButton2;


    Button register_btn;
    private static final String email_pattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private static final String phone_no_pattern = "[789][0-9]{9}";
    private Pattern pattern = Pattern.compile(email_pattern);
    private Matcher matcher;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        register_btn=findViewById(R.id.registerBtn);
        firstnamelayout=findViewById(R.id.firstnametextinput_layout);
        lastnamelayout=findViewById(R.id.lastnametextinput_layout);
        agelayout=findViewById(R.id.agetextinput_layout);
        arealayout=findViewById(R.id.areatextinput_layout);
        emailidlayout=findViewById(R.id.emailidtextinput_layout);
        phonennumberlayout=findViewById(R.id.phonetextinput_layout);

        first_ed_txt=findViewById(R.id.firstname_ed_txt);
        last_ed_txt=findViewById(R.id.lastname_ed_txt);
        age_edit_txt=findViewById(R.id.age_ed_txt);
        area_ed_txt=findViewById(R.id.localarea_ed_txt);
        email_ed_txt=findViewById(R.id.emailid_ed_txt);
        phoneno_ed_txt=findViewById(R.id.phone_no_ed_txt);

        radioButton1=findViewById(R.id.maleradiobutton);
        radioButton2=findViewById(R.id.femaleradiobutton);

//        Bundle bundle=getIntent().getExtras();
//        if (bundle!=null)
//        {
//            number=bundle.getString("phonenumber");
//        }


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation())
                {
                   //Toast.makeText(PatientRegistration.this, "Registration complete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validation()
    {
        String firstname=first_ed_txt.getText().toString();
        if (TextUtils.isEmpty(firstname))
        {
            firstnamelayout.setError(getString(R.string.empty_firstname));
            return false;
        }
        else if (!firstname.matches("[a-zA-Z ]+"))
        {
            firstnamelayout.setError(getString(R.string.enter_alphabetical_charater));
        }
        else {
            firstnamelayout.setError(null);
        }

        String lastname=last_ed_txt.getText().toString();
        if (TextUtils.isEmpty(lastname))
        {
            lastnamelayout.setError(getString(R.string.empty_lastname));
            return false;
        }
        else if (!lastname.matches("[a-zA-Z ]+"))
        {
            lastnamelayout.setError(getString(R.string.enter_alphabetical_charater));
        }
        else {
            lastnamelayout.setError(null);
        }

//        String male=radioButton1.getText().toString();
//        String female=radioButton2.getText().toString();
        if (!radioButton1.isChecked() && !radioButton2.isChecked())
        {
            Toast.makeText(this, getString(R.string.please_select_gender), Toast.LENGTH_SHORT).show();
        }
//        if (!male.matches("") && !female.matches("")){
//            Toast.makeText(this, getString(R.string.please_select_gender), Toast.LENGTH_SHORT).show();
//
//        }

        String age=age_edit_txt.getText().toString();
        if (TextUtils.isEmpty(age))
        {
            agelayout.setError(getString(R.string.empty_age));
            return false;
        }
        else {
            agelayout.setError(null);
        }


        String area=area_ed_txt.getText().toString();
        if (TextUtils.isEmpty(area))
        {
            arealayout.setError(getString(R.string.empty_area));
            return false;
        }
        else if (!area.matches("[a-zA-Z ]+"))
        {
            arealayout.setError(getString(R.string.enter_alphabetical_charater));
        }
        else {
            arealayout.setError(null);
        }


        String emailid=email_ed_txt.getText().toString();
        if (TextUtils.isEmpty(emailid))
        {
            emailidlayout.setError(getString(R.string.empty_emailid));
            return false;
        }
        if (!emailid.matches(email_pattern))
        {
            emailidlayout.setError(getString(R.string.invalid_email_id));
        }
        else {
            emailidlayout.setError(null);
        }


        String phoneno=phoneno_ed_txt.getText().toString();
        if (TextUtils.isEmpty(phoneno))
        {
            phonennumberlayout.setError(getString(R.string.empty_phone_no));
            return false;
        }
        if (!phoneno.matches(phone_no_pattern))
        {
            phonennumberlayout.setError(getString(R.string.invalid_phone_no));
            return false;
        }
        else {
            phonennumberlayout.setError(null);
        }
        return true;
    }
}
