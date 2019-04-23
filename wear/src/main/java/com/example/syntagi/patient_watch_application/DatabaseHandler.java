package com.example.syntagi.patient_watch_application;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.example.syntagi.patient_watch_application.enum_package.Reminder;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;
import com.google.gson.Gson;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "PatientApp";
    private static final String TABLE_MEDICINE = "Medicine";
    private Context context;
    private static final String KEY_ID = "_id";
    private static final String KEY_MEDICINE_TIME = "medicinetime";
    private static final String KEY_MEDICINE_NAME = "medicinename";

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


    public long addmedicine(MedicineData medicineData, Reminder reminder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEDICINE_TIME, reminder.getTime());
        values.put(KEY_MEDICINE_NAME, medicineData.getMedicineName());
        long id = db.insert(TABLE_MEDICINE, null, values);
        db.close();
        return id;
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from " +TABLE_MEDICINE ,null);
        return res;
    }



    public String getAllMedicineData() {
        MedicineData medicineData = new MedicineData();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        String json = sharedPreferences.getString("getmedicinename", "");
        Gson gson = new Gson();
        medicineData = gson.fromJson(json, MedicineData.class);

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT " + KEY_ID + "," + KEY_MEDICINE_TIME + "," + KEY_MEDICINE_NAME + " FROM " + TABLE_MEDICINE;
        Log.i("DB", "Query: " + query);
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
//            List<MedicineData> medicineDataList=new ArrayList<MedicineData>();
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
//                Reminder reminder=null;
//                if (reminder!=null){
//                    reminder.setTime(cursor.getString(1));
//                }
//               medicineData.setMedicineName(cursor.getString(2));
//                medicineDataList.add(medicineData);
            int mid = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String mtime = cursor.getString(cursor.getColumnIndex(KEY_MEDICINE_TIME));
            String mname = cursor.getString(cursor.getColumnIndex(KEY_MEDICINE_NAME));
            stringBuffer.append(mid + "" + mtime + "" + mname);
        }
//            return medicineDataList;
        return stringBuffer.toString();
    }

    public void deleteRow() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MEDICINE);
        db.close();
    }




  
//        public void getAllMedicine() {
//            List<MedicineData> medicineDataList = new ArrayList<MedicineData>();
//            String query = "select * from " + TABLE_MEDICINE;
//            SQLiteDatabase db = this.getWritableDatabase();
//            Cursor cursor = db.rawQuery(query, null);
//            if (cursor.moveToFirst()) {
//                do {
//                    MedicineData medicineData = new MedicineData();
//                    int id=cursor.getInt(0);
//                    medicineData.setMedicineId(cursor.getString(0));
//                    medicineData.setReminderId(cursor.getInt(1));
//                    medicineData.setMedicineName(cursor.getString(2));
//                } while (cursor.moveToNext());
//            }
//        }
////
    }