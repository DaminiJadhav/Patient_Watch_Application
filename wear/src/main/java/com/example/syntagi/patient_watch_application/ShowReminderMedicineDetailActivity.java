package com.example.syntagi.patient_watch_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.syntagi.patient_watch_application.sqlitedatabase.MedicineDatabaseModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ShowReminderMedicineDetailActivity extends AppCompatActivity implements CustomListAdapterInterface {
    ListView listView;
    List<MedicineDatabaseModel> medicinedatalist=new ArrayList<>();
    CustomListAdapter customListAdapter;
    DatabaseHandler databaseHandler=new DatabaseHandler(this);

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminder_medicine_detail);
       listView=findViewById(R.id.lv_showallmedicinenames);
        customListAdapter=new CustomListAdapter(ShowReminderMedicineDetailActivity.this,R.layout.row_medicinedetail_reminder,medicinedatalist,this);
        listView.setAdapter(customListAdapter);

        Intent intent=this.getIntent();
        String time=intent.getStringExtra(AppConstants.BUNDLE_KEYS.REMINDER_TIME);
        Log.i("ShowReminderMedicneDetailActivity","set reminder time =" +time);
        showdata(time);
    }
    public void getCurrentTime(){
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm a");
        String strdate=dateFormat.format(calendar.getTime());
            if (strdate!=null){
                databaseHandler.deleteReminderRow(strdate);
            }
    }

    public void showdata(String time){
        List<MedicineDatabaseModel> medicineDatabaseModels=databaseHandler.getAllMedicine(time);
//        StringBuffer data=new StringBuffer();
        for (int i=0;i<medicineDatabaseModels.size();i++){
            medicinedatalist.clear();
            medicinedatalist.addAll(medicineDatabaseModels);
//            data.append(medicineDatabase.getMedicineTime()).append(",").
//                    append(medicineDatabase.getMedicineName()).append("<br/>");
        }
        customListAdapter.notifyDataSetChanged();
//        textView.setText(Html.fromHtml(data.toString()));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent, int resourceID, LayoutInflater inflater) {
        AdapterHolder adapterHolder;
        if (convertView==null){
            convertView=inflater.inflate(resourceID,parent,false);
            adapterHolder=new AdapterHolder(convertView);
            convertView.setTag(adapterHolder);
        }
        else {
            adapterHolder= (AdapterHolder) convertView.getTag();
        }
        MedicineDatabaseModel medicineDatabaseModel=medicinedatalist.get(position);
        if (medicineDatabaseModel!=null){
            adapterHolder.mid.setText("" + medicineDatabaseModel.getId());
            adapterHolder.mtime.setText("" +medicineDatabaseModel.getMedicineTime());
            adapterHolder.mname.setText("" +medicineDatabaseModel.getMedicineName());
        }
        return convertView;
    }

    class AdapterHolder{
        private TextView mid,mtime,mname;
        public AdapterHolder(View view){
            mid=view.findViewById(R.id.tv_medicineid);
            mtime=view.findViewById(R.id.tv_medicinetime);
            mname=view.findViewById(R.id.tv_medicinename);
        }
    }
}
