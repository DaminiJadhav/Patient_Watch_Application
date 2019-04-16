package com.example.syntagi.patient_watch_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;

import java.util.ArrayList;
import java.util.List;

public class ShowReminderMedicineDetailDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="PatientApp";
    private static final String TABLE_MEDICINE="Medicine";
    private Context context;
    private static final String KEY_ID="id";
    private static final String KEY_MEDICINE_NAME="Medicine Name";
    private static final String KEY_MEDICINE_TIME="Medicine_Time";

    public ShowReminderMedicineDetailDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_MEDICINE_TABLE = "CREATE TABLE " + TABLE_MEDICINE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MEDICINE_NAME + "TEXT,"
                + KEY_MEDICINE_TIME + "TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_MEDICINE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//String DROP_TABLE="DROP TABLE " +TABLE_MEDICINE+ "";
//sqLiteDatabase.execSQL(DROP_TABLE);
    }

    void addmedicine(MedicineData medicineData){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_MEDICINE_NAME,medicineData.getMedicineName());
        values.put(KEY_MEDICINE_TIME,medicineData.getReminderId());
        db.insert(TABLE_MEDICINE,null,values);
        db.close();
    }
//    MedicineData getmedicine(int id){
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor=db.query(TABLE_MEDICINE,new String[]{ KEY_ID,KEY_MEDICINE_NAME,KEY_MEDICINE_TIME }, KEY_ID + "=?",new String[]{String.valueOf(id) },null,null,null,null);
//        if(cursor!=null)
//            cursor.moveToFirst();
//        MedicineData medicineData=new MedicineData(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
//        return medicineData;
//    }

    public List<MedicineData> getAllMedicine(){
        List<MedicineData> medicinelist=new ArrayList<MedicineData>();
        String selectquery="SELECT * FROM " +TABLE_MEDICINE;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectquery,null);
        if (cursor.moveToFirst()){
            do {
                MedicineData medicineData=new MedicineData();
                medicineData.setMedicineId(cursor.getString(0));
                medicineData.setMedicineName(cursor.getString(1));
//                medicineData.se;
                medicinelist.add(medicineData);
            }while(cursor.moveToNext());
        }
        return medicinelist;
    }









    public void deleteRow(String value)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM " +TABLE_MEDICINE+ "WHERE " +KEY_MEDICINE_NAME+ "=' "+value+"'");
        db.close();
    }


}

