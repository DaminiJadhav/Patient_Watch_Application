package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.syntagi.patient_watch_application.sqlitedatabase.MedicineDatabaseModel;
import java.util.ArrayList;
import java.util.List;

public class ShowReminderMedicineDetailActivity extends AppCompatActivity implements CustomListAdapterInterface {
    ListView listView;
    List<MedicineDatabaseModel> medicinedatalist=new ArrayList<>();
    CustomListAdapter customListAdapter;
    DatabaseHandler databaseHandler=new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminder_medicine_detail);
       listView=findViewById(R.id.lv_showallmedicinenames);
       customListAdapter=new CustomListAdapter(ShowReminderMedicineDetailActivity.this,R.layout.row_medicinedetail_reminder,medicinedatalist,this);
//        Toast.makeText(ShowReminderMedicineDetailActivity.this,"" +customListAdapter,Toast.LENGTH_LONG).show();
        listView.setAdapter(customListAdapter);
        showdata();
    }

    public void showdata(){
        List<MedicineDatabaseModel> medicineDatabaseModels=databaseHandler.getAllMedicine();
//        StringBuffer data=new StringBuffer();
        for (int i=0;i<medicineDatabaseModels.size();i++){
              medicinedatalist.addAll(medicineDatabaseModels);
//            data.append(medicineDatabase.getMedicineTime()).append(",").
//                    append(medicineDatabase.getMedicineName()).append("<br/>");
        }
        customListAdapter.notifyDataSetChanged();
//        medicinedatalist.clear();
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
