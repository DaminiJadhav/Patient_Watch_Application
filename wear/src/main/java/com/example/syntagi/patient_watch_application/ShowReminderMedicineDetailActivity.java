package com.example.syntagi.patient_watch_application;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.sqlitedatabase.MedicineDatabaseModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ShowReminderMedicineDetailActivity extends AppCompatActivity implements CustomListAdapterInterface {
    Button close,snooze;
    TextView time;
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
        close=findViewById(R.id.btn_close);
        snooze=findViewById(R.id.btn_snooze);
        time=findViewById(R.id.tv_time);
        customListAdapter=new CustomListAdapter(ShowReminderMedicineDetailActivity.this,R.layout.row_medicinedetail_reminder,medicinedatalist,this);
        listView.setAdapter(customListAdapter);
        final Intent intent=this.getIntent();
        final String time=intent.getStringExtra(AppConstants.BUNDLE_KEYS.REMINDER_TIME);
        Log.i("ShowReminderMedicneDetailActivity","set reminder time =" +time);
        showdata(time);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Close Activity", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
            }
        });

        snooze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowReminderMedicineDetailActivity.this,"Click Snooze Button",Toast.LENGTH_LONG).show();
        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(getApplicationContext(),AlarmReceiver.class);
        intent.putExtra("time",time);
        Log.i("ShowReminderMedicneDetailActivity", "set alarm after 5  minute: " +time);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
//        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent,0);
            alarmManager.cancel(pendingIntent);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,Calendar.getInstance().getTimeInMillis()+5*60000,pendingIntent);
                finish();
                System.exit(0);
                Log.i("ShowReminderMedicneDetailActivity","success");
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.btn_close:
//                finish();
//                Toast.makeText(this, "Close Activity", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.btn_snooze:
//                Toast.makeText(this,"Reminder remind after 5 minute",Toast.LENGTH_LONG).show();
//                return true;
//            default:
//                Toast.makeText(this, "Not Work Well", Toast.LENGTH_SHORT).show();
//                return super.onOptionsItemSelected(item);
//        }
        return super.onOptionsItemSelected(item);
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
//            adapterHolder.mid.setText("" + medicineDatabaseModel.getId());
            adapterHolder.mtime.setText("" +medicineDatabaseModel.getMedicineTime());
            adapterHolder.mname.setText("" +medicineDatabaseModel.getMedicineName());
        }
        return convertView;
    }

    class AdapterHolder{
        private TextView mid,mtime,mname;
        public AdapterHolder(View view){
//            mid=view.findViewById(R.id.tv_medicineid);
            mtime=view.findViewById(R.id.tv_medicinetime);
            mname=view.findViewById(R.id.tv_medicinename);
        }
    }
}
