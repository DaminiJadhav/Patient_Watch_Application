package com.example.syntagi.patient_watch_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import com.example.syntagi.patient_watch_application.models.medicine.MedicineData;

public class ShowReminderMedicineDetailsDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_details_db);
        VivzHelper vivzHelper=new VivzHelper(ShowReminderMedicineDetailsDB.this);

    }

    public class VivzHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION=1;
        private static final String DATABASE_NAME="PatientApp";
        private static final String TABLE_MEDICINE="Medicine";
        private Context context;
        private static final String KEY_ID="id";
        private static final String KEY_MEDICINE_NAME="Medicine Name";
        private static final String KEY_MEDICINE_TIME="Medicine_Time";


        public VivzHelper(Context context){
            super(context,DATABASE_NAME,null,1);

        }

//        public VivzHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//            super(context, name, factory, version);
//            this.context=context;
//        }

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
        public void deleteRow(String value)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            db.execSQL("DELETE FROM " +TABLE_MEDICINE+ "WHERE " +KEY_MEDICINE_NAME+ "=' "+value+"'");
            db.close();
        }
    }


}
