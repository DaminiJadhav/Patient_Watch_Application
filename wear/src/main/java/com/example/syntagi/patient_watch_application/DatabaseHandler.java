package com.example.syntagi.patient_watch_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.syntagi.patient_watch_application.enum_package.Reminder;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.example.syntagi.patient_watch_application.sqlitedatabase.MedicineDatabaseModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "PatientApp";
    private static final String TABLE_MEDICINE = "Medicine";
    private Context context;
    private static final String KEY_ID = "_id";
    private static final String KEY_MEDICINE_TIME = "medicinetime";
    private static final String KEY_MEDICINE_NAME = "medicinename";
    MedicineDatabaseModel medicinedata;
    long id;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_MEDICINE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_MEDICINE_TIME + " VARCHAR(100)," + KEY_MEDICINE_NAME + " VARCHAR(100));";
        sqLiteDatabase.execSQL(query);
        Log.i("DB", "Query: " + query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_MEDICINE + " ";
        sqLiteDatabase.execSQL(query);
        Log.i("DB", "Query: " + query);
    }


    public int addmedicine(MedicineData medicineData, Reminder reminder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEDICINE_TIME, reminder.getTime());
        values.put(KEY_MEDICINE_NAME, medicineData.getMedicineName());
         id = db.insert(TABLE_MEDICINE, null, values);
        db.close();
        return (int) id;
    }

    public List<MedicineDatabaseModel> getAllMedicine(String reminderTime){
        Log.i("DatabaseHandler","reminder time: " +reminderTime);
       SQLiteDatabase db=this.getWritableDatabase();
       List<MedicineDatabaseModel> medicineDataList=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm a");
        String strdate=dateFormat.format(calendar.getTime());
//        String query="select * from Medicine";
       Cursor cursor=db.rawQuery("SELECT * FROM " +TABLE_MEDICINE+ " WHERE " +KEY_MEDICINE_TIME + "='" +reminderTime + "'",null);
//     Cursor cursor=db.rawQuery(query,null);
       while (cursor.moveToNext()){
           int id=cursor.getInt(cursor.getColumnIndex(KEY_ID));
           String time=cursor.getString(cursor.getColumnIndex(KEY_MEDICINE_TIME));
           String name=cursor.getString(cursor.getColumnIndex(KEY_MEDICINE_NAME));
           medicinedata=new MedicineDatabaseModel();
           medicinedata.setId(id);
           medicinedata.setMedicineTime(time);
           medicinedata.setMedicineName(name);
           medicineDataList.add(medicinedata);
       }
        return medicineDataList;
    }

    public void deleteRow(String medicinename) {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DELETE FROM " + TABLE_MEDICINE);
        db.execSQL("DELETE FROM " +TABLE_MEDICINE +  " WHERE "  +KEY_MEDICINE_NAME+ "='" +medicinename+ "'");
        db.close();
    }

        public void deleteReminderRow(String time){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM " +TABLE_MEDICINE + " WHERE " +KEY_MEDICINE_TIME + "='" +time+ "'");
//        db.execSQL("DELETE FROM " + TABLE_MEDICINE + " WHERE " +KEY_ID+ "='" +medicinedata.getId()+ "'" + " AND "+KEY_MEDICINE_TIME+ "='" + medicinedata.getMedicineTime() + "'" + " AND " +KEY_MEDICINE_NAME+ "='" +medicinedata.getMedicineName()+ "'");
            db.close();
         }

    public String getAllMedicineData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT " + KEY_ID + "," + KEY_MEDICINE_TIME + "," + KEY_MEDICINE_NAME + " FROM " + TABLE_MEDICINE;
        Log.i("DB", "Query: " + query);
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int mid = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String mtime = cursor.getString(cursor.getColumnIndex(KEY_MEDICINE_TIME));
            String mname = cursor.getString(cursor.getColumnIndex(KEY_MEDICINE_NAME));
            stringBuffer.append(mid + "" + mtime + "" + mname);
//            Intent intent=new Intent(context.getApplicationContext(),ShowReminderMedicineDetailActivity.class);
//            intent.putExtra("ID",mid);
//            intent.putExtra("MedicineTime",mtime);
//            intent.putExtra("MedicineName",mname);
//            context.startActivity(intent);
        }
//            return medicineDataList;
        return stringBuffer.toString();
    }
}