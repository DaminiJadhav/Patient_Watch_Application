package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyVitalsFragment extends Fragment {
    ImageView  imageView;
    LinearLayout layout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view= inflater.inflate(R.layout.my_vitals,container,false);
       layout = view.findViewById(R.id.lay_container);
         imageView= view.findViewById(R.id.iv_vitals);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment();
//                clickmethod();
            }
        });

        return view;
    }


    private void swapFragment() {
      getFragmentManager().beginTransaction().add(R.id.lay_container,VitalFragment.getInstance()).commit();
    }

    public void myClickMethod(View v){
        VitalFragment.myClickMethod(v);
    }

    public void clickmethod(){
        VitalFragment vitalFragment = new VitalFragment();
            Bundle extras=getIntent().getExtras();
            if (extras!=null){
                vitalFragment.setArguments(extras);
                getFragmentManager().beginTransaction().add(R.id.lay_container,VitalFragment.getInstance()).commit();


        }

//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(R.id.lay_container, vitalFragment);
//            fragmentTransaction.commit();
    }

    private Intent getIntent() {
        return null;
    }


}
