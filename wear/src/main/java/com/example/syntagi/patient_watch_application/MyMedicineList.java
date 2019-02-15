package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.models.medicine.CurrentMedicineResponse;
import com.example.syntagi.patient_watch_application.models.medicine.GetMedicineData;
import com.example.syntagi.patient_watch_application.models.medicine.MedicationEndsOn;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyMedicineList extends AppCompatActivity {
    TextView textView;
    ViewPager viewPager;
    GetMedicineData getMedicineData;
    List<Fragment> fragments=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_medicine_list);
        textView=findViewById(R.id.medicine_data);
        viewPager=findViewById(R.id.medicine_viewpager);





        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(MyMedicineList.this);
        String json=sharedPreferences.getString("Medicine","");
        Gson gson=new Gson();
        getMedicineData=gson.fromJson(json,GetMedicineData.class);
        if (getMedicineData!=null){
            for (Map.Entry<String, MedicationEndsOn> entry:getMedicineData.getCurrentMedicines().entrySet()){
                fragments.add(MyMedicine.getInstance(entry.getValue()));
            }
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new Myadapter(fragmentManager));
    }

    class Myadapter extends FragmentPagerAdapter{

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
