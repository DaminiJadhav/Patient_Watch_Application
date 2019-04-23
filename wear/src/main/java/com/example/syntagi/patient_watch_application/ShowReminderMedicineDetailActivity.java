package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.enum_package.Reminder;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import java.util.List;

public class ShowReminderMedicineDetailActivity extends AppCompatActivity {
TextView textView;
    DatabaseHandler databaseHandler=new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminder_medicine_detail);
       textView=findViewById(R.id.tv_empty);
        viewAll();
    }

    public void viewAll(){
        Cursor res=databaseHandler.getAllData();
        if (res.getCount()==0){
            showmessage("Error","Nothing found");
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while (res.moveToNext()){
            Toast.makeText(ShowReminderMedicineDetailActivity.this,"view all data successfully",Toast.LENGTH_LONG).show();
            buffer.append("Id :" +res.getString(0)+"\n");
            buffer.append("Time :" +res.getString(1)+"\n");
            buffer.append("Name :" +res.getString(2)+"\n");
          }
        showmessage("Data",buffer.toString());

    }

    public void showmessage(String title,String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
        public void showdata(){
    //        List<MedicineData> medicineData=databaseHandler.getAllMedicineData();
    //        StringBuffer data=new StringBuffer();
    //        for (int i=0;i<medicineData.size();i++){
    //            MedicineData medicinedata=medicineData.get(i);
    //            Reminder reminder=null;
    ////            Reminder reminder1=new Reminder(1,reminder.getTime());
    //            data.append(reminder.getTime()).append(",").
    //                    append(medicinedata.getMedicineName()).append("<br/>");
    //        }
    ////        textView.setText(Html.fromHtml(data.toString()));
        }

}
